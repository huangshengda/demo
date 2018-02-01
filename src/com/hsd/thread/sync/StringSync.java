/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.thread.sync;

/**  
 * @Description: String字符串
 * @author huangshengda  
 * @date 2018年1月12日   
 * @version  1.0
*/
public class StringSync {

	private String str;

	public StringSync(String str) {
		super();
		this.str = str;
	}

	private static int num = 0;

	public void method() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (str) {
			for (int a = 0; a < 10000; a++) {

				System.out.println(num++);
			}
		}
	}

	public static void main(String[] args) {
		final StringSync stringSync1 = new StringSync("obj");
		// final StringSync stringSync2 = new StringSync("obj");

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					stringSync1.method();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					stringSync1.method();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
