package com.hsd.zk;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class ZkSessionIdAndPwd implements Watcher{
	private static CountDownLatch sp = new CountDownLatch(1);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ZooKeeper zk = new ZooKeeper("127.0.0.1.:2181/zookeeper",5000, new ZkSessionIdAndPwd());
		System.out.println(zk.getState());
		try {
			sp.await();
		} catch (Exception e) {
			// TODO: handle exception
		}
		long sessionId = zk.getSessionId();
		byte[] sessionPasswd = zk.getSessionPasswd();
	
		//zk = new ZooKeeper("127.0.0.1.:2181/zookeeper",5000, new ZkSessionIdAndPwd(),1,"".getBytes());
		zk = new ZooKeeper("127.0.0.1.:2181/zookeeper",5000, new ZkSessionIdAndPwd(),sessionId,sessionPasswd);
		Thread.sleep(Integer.MAX_VALUE);
		//System.out.println("finished!");
	}
	
	@Override
	public void process(WatchedEvent event) {
		System.out.println("Received watched event" + event);
		if(KeeperState.SyncConnected == event.getState()){
			sp.countDown();
		}
		
	}

}
