package com.hsd.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

	private Object person;// 被代理人

	// 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理。但是要注意下面的newProxyInstance（）中的参数
	public Object getInstance(Object person) {
		this.person = person;
		// 与cglib的区别在于这里构建代理对象的时候需要传入被代理对象的接口对象，第二个参数。而cglib不需要被代理对象实现任何接口即可
		return Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("doSomething---------start");
		method.invoke(person, args);
		System.out.println("doSomething---------end");
		return null;
	}

	public static void main(String[] args) {
		Person person = (Person) new JDKProxy().getInstance(new MrLi());
		// 注意这里的person不是目标类person，而是代理类person：debug的时候显示null，有'$'标识符
		person.doWork();
	}

}
