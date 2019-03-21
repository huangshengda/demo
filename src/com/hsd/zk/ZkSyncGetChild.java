package com.hsd.zk;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;

public class ZkSyncGetChild implements Watcher{

	private static CountDownLatch sp = new CountDownLatch(1);
	
	private static ZooKeeper zk = null;
	
	@Override
	public void process(WatchedEvent event) {
		System.out.println("Received watched event" + event);
		if(KeeperState.SyncConnected == event.getState()){
			if(EventType.None == event.getType() && null == event.getPath()){
				sp.countDown();
			}else if(EventType.NodeChildrenChanged == event.getType()){
				try {
					System.out.println("rrr" + zk.getChildren(event.getPath(), true));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		zk = new ZooKeeper("127.0.0.1.:2181",5000, new ZkSyncGetChild());
		sp.await();
		String create1 = zk.create("/zookeeper/e", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		//zk.create("/zookeeper/e/t", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		System.out.println(create1);
		List<String> children = zk.getChildren("/zookeeper", true);
		System.out.println(children);
		zk.create("/zookeeper/e1", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		Thread.sleep(Integer.MAX_VALUE);
	}

}
