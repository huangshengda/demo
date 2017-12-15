/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.serializable;

import java.io.Serializable;

/**  
 * @Description: Person
 * @author huangshengda  
 * @date 2017年12月15日   
 * @version  1.0
*/
public class Person implements Serializable {

	/** 
	 * @Description: serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 1L;

	private String name1;

	private String age;

	private String phone;

	public Person(String name, String age) {
		super();
		this.name1 = name;
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name1;
	}

	public void setName(String name) {
		this.name1 = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name1=");
		builder.append(name1);
		builder.append(", age=");
		builder.append(age);
		builder.append(", phone=");
		builder.append(phone);
		builder.append("]");
		return builder.toString();
	}

}
