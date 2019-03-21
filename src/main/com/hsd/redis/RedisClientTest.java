package main.com.hsd.redis;

import redis.clients.jedis.Jedis;

public class RedisClientTest {



	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.74.128", 6379);
		jedis.set("id", "01");// <key,value>
		System.out.println(jedis.get("id"));
	}
}
