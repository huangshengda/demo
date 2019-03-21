/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.arithmetic;

/**  
 * @Description: 最大公约数
 * @author huangshengda  
 * @date 2018年1月4日   
 * @version  1.0
*/
public class Gongyueshu {

	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}

	public static void main(String[] args) {
		System.out.println(gcd(8888, 8));
	}
}
