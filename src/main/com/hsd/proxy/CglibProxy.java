package main.com.hsd.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Object targetObject;

	// 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理
	public Object getInstance(Object target) {
		this.targetObject = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		// 注意该处代理的创建过程
		Object proxyObj = enhancer.create();
		return proxyObj;// 返回代理对象
	}

	@Override
	public Object intercept(Object arg0, Method method, Object[] arg2, MethodProxy arg3) throws Throwable {
		Object obj = null;
		System.out.println("doSomething---------start");
		obj = method.invoke(targetObject, arg2);
		System.out.println("doSomething---------end");
		return obj;
	}

	public static void main(String[] args) {
		MrLi person = (MrLi) new CglibProxy().getInstance(new MrLi());
		person.doWork();
	}

}
