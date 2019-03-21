/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.overload;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huangshengda  
 * @date 2018年1月10日   
 * @version  1.0
*/
public class SuperClass {

	private int value;

	public void method(SuperClass p) {

		this.value += p.value;

	}

	public void addValue(int v) {

		value += v;

	}

	public int getValue() {

		return value;

	}

	public static void main(String[] args) {
		SuperClass o2;

		SubClass o3;

		o2 = new SubClass();

		o3 = new SubClass();

		o2.method(o3);
		System.out.println(o2.getValue());

		o3.method(o3);
		System.out.println(o3.getValue());

	}
}

class SubClass extends SuperClass {

	public void method(SubClass p) {

		super.method(p);

		this.addValue(4);

	}

	public void method(SuperClass p) {

		this.addValue(10);

	}

}
