/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.annotation;

/**  
 * @Description: TestAnnotation
 * @author huangshengda  
 * @date 2017年12月15日   
 * @version  1.0
*/
@UserAnnotation(name = "zhangsan", password = "123456")
public class TestAnnotation {

	public static void main(String[] args) {
		// 使用反射进行参数注解
		UserAnnotation annotation = TestAnnotation.class.getAnnotation(UserAnnotation.class);
		// 测试注解
		System.out.println(annotation.name() + "__" + annotation.password());
	}

}
