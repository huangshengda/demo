package com.hsd.proxy;

public class StaticProxy implements Person {
	private Person person;// 被代理人

	// 这里的目标类型决定了该代理类只能代理实现了Person接口的实例，而不能接收其他类型参数，这也就是静态代理的局限性
	public StaticProxy(Person person) {
		this.person = person;
	}

	@Override
	public void doWork() {
		System.out.println("doSomething-----start");
		person.doWork();
		System.out.println("doSomething-----end");

	}

	public static void main(String[] args) {
		MrLi li = new MrLi();
		StaticProxy proxy = new StaticProxy(li);
		// 调用处直接调用代理进行目标方法的操作。
		proxy.doWork();
	}

}
