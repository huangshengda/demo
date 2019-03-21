/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.arithmetic.sort;

/**  
 * @Description: 插入排序
 * @author huangshengda  
 * @date 2018年1月9日   
 * @version  1.0
*/
@SuppressWarnings("rawtypes")
public class Insertion {

	public static void main(String[] args) {
		Comparable[] a = { "s", "y", "a", "f", "c", "u", "v", "u", "e" };
		sort(a);
		assert isSorted(a);
		show(a);

	}

	public static void sort(Comparable[] a) {
		int num = a.length;
		for (int i = 1; i < num; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
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
