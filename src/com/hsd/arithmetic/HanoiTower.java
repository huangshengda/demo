/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.arithmetic;

/**  
 * @Description: HanoiTower
 * @author huangshengda  
 * @date 2017年11月20日   
 * @version  1.0
*/
public class HanoiTower {
	public static void moveDish(int level, char from, char inter, char to) {
		if (level == 1) {
			System.out.println("从" + from + " 移动盘子" + level + " 号到" + to);
		} else {
			moveDish(level - 1, from, to, inter);
			System.out.println("从" + from + " 移动盘子" + level + " 号到" + to);
			moveDish(level - 1, inter, from, to);
		}
	}

	public static void main(String[] args) {
		int nDisks = 9;
		moveDish(nDisks, 'A', 'B', 'C');
	}
}
