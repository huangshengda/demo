/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.arithmetic;

import com.hsd.util.StdIn;
import com.hsd.util.StdOut;

/**  
 * @Description: UnionFindTwo
 * @author huangshengda  
 * @date 2018年1月5日   
 * @version  1.0
*/
public class UnionFindTwo {

	private int[] id;
	private int count;

	public UnionFindTwo(int count) {
		this.count = count;
		id = new int[count];
		for (int i = 0; i < count; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return this.count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int pId = find(p);
		int qId = find(q);
		if (pId == qId) {
			return;
		}
		id[pId] = qId;
		count--;
	}

	public static void main(String[] args) {
		int readInt = StdIn.readInt();
		UnionFindTwo unionFindOne = new UnionFindTwo(readInt);
		while (unionFindOne.count != 1) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (unionFindOne.connected(p, q)) {
				continue;
			}
			unionFindOne.union(p, q);
			StdOut.println(p + " " + q);
			printArr(unionFindOne.id);
			StdOut.println(unionFindOne.count);
		}
		printArr(unionFindOne.id);
	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "-");
		}
		System.out.println();
	}

}
