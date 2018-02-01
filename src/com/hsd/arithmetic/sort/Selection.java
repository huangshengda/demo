/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.arithmetic.sort;

/**  
 * @Description: 选择排序算法
 * @author huangshengda  
 * @date 2018年1月9日   
 * @version  1.0
*/
@SuppressWarnings("rawtypes")
public class Selection {

	public static void main(String[] args) {
		Comparable[] a = { "s", "y", "a", "f", "c", "u", "v", "", "e" };
		sort(a);
		assert isSorted(a);
		show(a);

	}

	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int temp = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[temp])) {
					temp = j;
				}
				exch(a, i, temp);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
