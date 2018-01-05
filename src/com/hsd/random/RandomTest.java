/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.random;

import java.util.Random;

/**  
 * @Description: 随机数测试
 * @author huangshengda  
 * @date 2018年1月4日   
 * @version  1.0
*/
public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random(10);
		System.out.println(random.nextInt());
		Random random1 = new Random(10);
		System.out.println(random1.nextInt());
	}
}
