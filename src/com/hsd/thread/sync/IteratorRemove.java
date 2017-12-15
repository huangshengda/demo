/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.thread.sync;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**  
 * @Description: 并发移动iterator
 * @author huangshengda  
 * @date 2017年11月24日   
 * @version  1.0
*/
public class IteratorRemove {

	List<Person> list = new ArrayList<Person>();

	public IteratorRemove() {
		list.add(new Person("jack"));
	}

	public static void main(String[] args) throws InterruptedException {
		final IteratorRemove iteratorRemove = new IteratorRemove();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("t");
				Iterator<Person> iterator = iteratorRemove.list.iterator();
				iterator.next();
				iterator.remove();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		Thread.sleep(500);
		System.out.println(iteratorRemove.list);
	}

	class Person {
		private String name;

		public Person(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
