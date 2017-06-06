package com.hsd.pattern.singleton;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author huangshengda  
 * @date 2017年6月3日   
 *  
*/
public class Singleton {

	private static class InnerSingleton {
		static final Singleton instance = new Singleton();
	}

	public Singleton getInstance() {
		return InnerSingleton.instance;
	}
}
