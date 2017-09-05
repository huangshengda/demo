package com.hsd.zookeeper.watcher.main;

import com.hsd.zookeeper.watcher.impl.Police;
import com.hsd.zookeeper.watcher.impl.Security;
import com.hsd.zookeeper.watcher.impl.Thief;
import com.hsd.zookeeper.watcher.impl.Transporter;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author huangshengda  
 * @date 2017年8月30日   
 *  
*/
public class Test {
	public static void main(String[] args) {
		Transporter transporter = new Transporter();

		Police police = new Police();
		Security security = new Security();
		Thief thief = new Thief();

		transporter.addWatcher(police);
		transporter.addWatcher(security);
		transporter.addWatcher(thief);

		transporter.notifyWatchers();
	}
}
