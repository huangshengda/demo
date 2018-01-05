/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.arithmetic;

/**  
 * @Description: 二分查找法
 * @author huangshengda  
 * @date 2018年1月4日   
 * @version  1.0
*/
public class BinarySearch {

	public static int rank(int key, int[] a) {
		return binarySearch(key, a, 0, a.length - 1);
	}

	public static int binarySearch(int key, int[] a, int lo, int hi) {
		if (hi > lo) {
			return -1;
		}

		int mid = lo + (lo + hi) / 2;

		if (key < a[mid]) {
			return binarySearch(key, a, lo, mid - 1);
		} else if (key > a[mid]) {
			return binarySearch(key, a, mid + 1, hi);
		} else {
			return mid;
		}
	}

}
