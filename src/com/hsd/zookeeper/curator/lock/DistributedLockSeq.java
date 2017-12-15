/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.zookeeper.curator.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.data.Stat;

/**
 * 
 * <p>Description: </p>
 * @date 2016年5月12日
 * @author 李世佳 
 */
public class DistributedLockSeq {

	public static final String LOCK_ZNODE = "/rrrrw";

	public static CuratorFramework client;

	public static CuratorFrameworkFactory.Builder builder;

	static {
		client = CuratorFrameworkFactory.newClient("10.5.52.68:2181,10.5.52.69:2181,10.5.52.70:2181", new ExponentialBackoffRetry(1000, 3));

		builder = CuratorFrameworkFactory.builder().connectString("172.16.35.9:2181").retryPolicy(new ExponentialBackoffRetry(1000, 3));
		// etc. etc.
	}

	public static void main(String[] args) {

		final ExecutorService service = Executors.newFixedThreadPool(20);

		for (int i = 0; i < 1; i++) {
			service.execute(new SeqTask("[Concurrent-" + i + "]"));
		}

		if (!service.isShutdown()) {
			try {
				service.shutdown();
				if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
					service.shutdownNow();
				}
			} catch (InterruptedException e) {
				service.shutdownNow();
				System.out.println(e.getMessage());
			}
		}
	}

	// 借助curatorFramework利用Zookeeper实现分布式seq生成
	public static class SeqTask implements Runnable {

		private final String seqTaskName;

		public SeqTask(String seqTaskName) {
			this.seqTaskName = seqTaskName;
		}

		@Override
		public void run() {
			CuratorFramework client = builder.build();
			client.start();
			// 锁对象 client 锁节点
			InterProcessMutex lock = new InterProcessMutex(client, LOCK_ZNODE);
			try {
				boolean retry = true;
				int i = 0;
				do {
					i++;
					System.out.println(seqTaskName + " recome:" + i);
					// 索取锁,设置时长1s,如果获取不到，则继续获取
					if (lock.acquire(1000, TimeUnit.MILLISECONDS)) {
						Stat stat = client.checkExists().forPath(LOCK_ZNODE);
						if (stat != null) {
							// 获取锁操作则增加序列
							byte[] oldData = client.getData().storingStatIn(stat).forPath(LOCK_ZNODE);
							String s = new String(oldData);
							int d = Integer.parseInt(s);
							d = d + 1;
							s = String.valueOf(d);
							byte[] newData = s.getBytes();
							client.setData().forPath(LOCK_ZNODE, newData);
							System.out.println(seqTaskName + " obtain seq :" + new String(newData));
						}
						retry = false;
					}
				} while (retry);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (lock.isAcquiredInThisProcess()) {
						lock.release();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					CloseableUtils.closeQuietly(client);
				}
			}
		}
	}
}
