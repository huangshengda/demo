package com.hsd.zookeeper.watcher.impl;

import com.hsd.zookeeper.watcher.i.Watcher;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author huangshengda  
 * @date 2017年8月30日   
 *  
*/
public class Thief implements Watcher {
	@Override
	public void update() {
		System.out.println("运输车有行动，强盗准备动手");
	}
}
