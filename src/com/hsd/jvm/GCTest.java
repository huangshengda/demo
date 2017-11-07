/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.jvm;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huangshengda  
 * @date 2017年11月7日   
 * @version  1.0
*/
public class GCTest {

	private static final int SIZE = 1024 * 1024;

	/**
	 * 
	 * @Description: vm参数 : -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * @author huangshengda 
	 * @version 1.0
	 */
	private static void testAllocation() {
		byte[] allocation1 = new byte[2 * SIZE];
		byte[] allocation2 = new byte[2 * SIZE];
		byte[] allocation3 = new byte[2 * SIZE];
		byte[] allocation4 = new byte[4 * SIZE];

	}

	public static void main(String[] args) {
		testAllocation();
	}
}
