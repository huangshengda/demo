package main.com.hsd.zk;

import org.I0Itec.zkclient.ZkClient;

public class ZkClientTest {

	public static void main(String[] args) {
		ZkClient zkClient = new ZkClient("127.0.0.1.:2181/zookeeper", 5000);
		zkClient.createPersistent("/t/r", true);
	}
}
