package com.hsd.zk;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback.StringCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZkAsyncCreate implements Watcher {
	private static CountDownLatch sp = new CountDownLatch(1);

	@Override
	public void process(WatchedEvent event) {
		System.out.println("Received watched event: " + event);
		System.out.println(event.getState());
		if (KeeperState.SyncConnected == event.getState()) {
			System.out.println("rrrrrrrrr");
			sp.countDown();
		}
	}

	public static void main(String[] args) throws Exception {
		ZooKeeper zk = new ZooKeeper("127.0.0.1.:2181/zookeeper", 5000, new ZkAsyncCreate());
		sp.await();
		zk.create("/t", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, new IStringCallback(), "i am context");
		System.out.println("rrr");
		zk.create("/t", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL, new IStringCallback(), "i am context");
		Thread.sleep(Integer.MAX_VALUE);
	}

}

class IStringCallback implements StringCallback {

	@Override
	public void processResult(int rc, String path, Object ctx, String name) {
		System.out.println("create path result rc = " + rc + " patch =" + path + ", ctx = " + ctx + ", name = " + name);
	}

}
