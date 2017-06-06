package com.codyy.demo;

public class ThreadStart {

	public static void main(String[] args) {
		Thread thread = new Thread("Thread-name"){
			public void run(){
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		thread.start();
	}

}
