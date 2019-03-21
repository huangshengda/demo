/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.thread.sync;

/**  
 * @Description: Say(这里用一句话描述这个类的作用)
 * @author huangshengda  
 * @date 2017年11月23日   
 * @version  1.0
*/
public class Say {

	Object obj;

	public Say(Object obj) {
		this.obj = obj;
	}

	public void sayHello() {

		synchronized (obj) {
			System.out.println("hello one!");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("hello two!");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();

		final Say say = new Say(obj);
		new Thread(new Runnable() {
			public void run() {
				say.sayHello();
			}
		}).start();

		Thread.sleep(2000);
		synchronized (obj) {
			System.out.println("hello main!");
		}
	}
}
