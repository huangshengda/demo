/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.arithmetic;

import java.util.Scanner;

/**  
 * @Description: 字符串反序
 * @author huangshengda  
 * @date 2017年11月20日   
 * @version  1.0
*/
public class ReverseStr {

	public static void main(String[] args) {
		reverseStr();
	}

	public static void reverseStr() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个字符:");
		String next = scan.next();
		if (!"#".equals(next)) {
			reverseStr();
		}
		if (!"#".equals(next)) {
			System.out.println(next);
		}
		scan.close();
	}
}
