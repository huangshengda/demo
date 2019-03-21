/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.overridehashcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huangshengda  
 * @date 2017年11月27日   
 * @version  1.0
*/
public class Test {

	public static void main(String[] args) {

		Set<Test> set = new HashSet<>();
		Test p = new Test("jack");
		set.add(p);
		Test q = new Test("jack");
		set.add(q);
		System.out.println(set);

		Map<Test, String> map = new HashMap<>();
		map.put(p, "j");
		map.put(q, "q");
		System.out.println(map);

	}

	private String name;

	public Test(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
