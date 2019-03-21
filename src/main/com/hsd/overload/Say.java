/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.overload;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huangshengda  
 * @date 2018年1月10日   
 * @version  1.0
*/
public class Say extends AbstractSay implements SayInter {

	@Override
	public void say() {
		System.out.println("jack");
	}

	public static void main(String[] args) {
		SayInter s = new Say();
		s.say();
	}
}
