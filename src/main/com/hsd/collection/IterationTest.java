/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.collection;

import java.util.ArrayList;
import java.util.List;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huangshengda  
 * @date 2017年11月9日   
 * @version  1.0
*/
public class IterationTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);

		/*Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			//iterator.next();
			iterator.remove();
		}*/
		System.out.println(list);
	}
}
