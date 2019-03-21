package main.com.hsd.guava;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimtiterTest {

	public static void main(String[] args) {
		RateLimiter create = RateLimiter.create(1);
		System.out.println(create.acquire(5));
		System.out.println(create.acquire());
		System.out.println(create.acquire());
		System.out.println(create.acquire());
		System.out.println(create.acquire());
		System.out.println(create.acquire());
	}
	
}
