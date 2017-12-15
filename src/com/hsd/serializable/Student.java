/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.serializable;

import java.io.Serializable;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huangshengda  
 * @date 2017年12月15日   
 * @version  1.0
*/
public class Student implements Serializable {

	/** 
	 * @Description: serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 2L;

	private String phone;

	public Student(String phone) {
		super();
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
