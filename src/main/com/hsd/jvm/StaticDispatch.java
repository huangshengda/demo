/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.jvm;

/**  
 * @Description: StaticDispatch
 * @author huangshengda  
 * @date 2017年11月21日   
 * @version  1.0
*/
public class StaticDispatch {

	static abstract class Human {
	}

	static class Man extends Human {
	}

	static class Woman extends Human {
	}

	public void sayHello(Human guy) {
		System.out.println("hi guy!");
	}

	public void sayHello(Man guy) {
		System.out.println("hi man!");
	}

	public void sayHello(Woman guy) {
		System.out.println("hi woman!");
	}

	public static void main(String[] args) {
		StaticDispatch staticDispatch = new StaticDispatch();
		Human man = new Man();
		Human woman = new Woman();
		staticDispatch.sayHello(man);
		staticDispatch.sayHello(woman);
	}
}
