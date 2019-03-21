package main.com.hsd.zk;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZkSyncCreate implements Watcher{
	private static CountDownLatch sp = new CountDownLatch(1);
	
	@Override
	public void process(WatchedEvent event) {
		System.out.println("Received watched event" + event);
		if(KeeperState.SyncConnected == event.getState()){
			sp.countDown();
		}
	}
	
	public static void main(String[] args) throws Exception {
		ZooKeeper zk = new ZooKeeper("127.0.0.1.:2181/zookeeper",5000, new ZkSyncCreate());
		sp.await();
		String create1 = zk.create("/zookeeper", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		System.out.println(create1);
		String create2 = zk.create("/zookeeper", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println(create2);
		Thread.sleep(Integer.MAX_VALUE);
	}

	
}
