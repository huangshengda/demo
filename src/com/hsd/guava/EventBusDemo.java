package com.hsd.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusDemo {

	public static void main(String[] args) {
		EventBus eventBus = new EventBus("jack");
		/*
		  如果多个subscriber订阅了同一个事件,那么每个subscriber都将收到事件通知
		  并且收到事件通知的顺序跟注册的顺序保持一致
		 */
		eventBus.register(new EventListener()); // 注册订阅者
		eventBus.register(new MultiEventListener());
		eventBus.post(new OrderEvent("hello")); // 发布事件
		eventBus.post(new OrderEvent("world"));
		eventBus.post("!");
	}
}

class MultiEventListener {

	@Subscribe
	public void listen(OrderEvent event) {
		System.out.println("receive msg: " + event.getMessage());
	}

	@Subscribe
	public void listen(String message) {
		System.out.println("receive msg: " + message);
	}
}

class EventListener { // 订阅者

	// @Subscribe保证有且只有一个输入参数,如果你需要订阅某种类型的消息,只需要在指定的方法上加上@Subscribe注解即可
	@Subscribe
	public void listen(OrderEvent event) {
		System.out.println("receive message: " + event.getMessage());
	}

	/*
	  一个subscriber也可以同时订阅多个事件
	  Guava会通过事件类型来和订阅方法的形参来决定到底调用subscriber的哪个订阅方法
	 */
	@Subscribe
	public void listen(String message) {
		System.out.println("receive message: " + message);
	}
}

class OrderEvent { // 事件
	private String message;

	public OrderEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
