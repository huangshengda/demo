/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/** 
 * @author Administrator 
 * 自定义用户注解 
 */
// 注解定义
@Documented
// 注解生命周期
@Retention(RetentionPolicy.RUNTIME)
// 注解的作用范围 设定作用构造器 字段 方法 包等
public @interface UserAnnotation {
	// 定义注解 的基本的
	String name();

	// 定义属性值
	String password();

}
