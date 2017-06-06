package com.codyy.annotation.fruit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author huangshengda  
 * @date 2017年4月19日   
 *  
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
	/**
	 * 供应商编号
	 * @return
	 */
	public int id() default -1;

	/**
	 * 供应商名称
	 * @return
	 */
	public String name() default "";

	/**
	 * 供应商地址
	 * @return
	 */
	public String address() default "";
}
