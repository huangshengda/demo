package com.hsd.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaCacheDemo {

	public static void main(String[] args) {
		LoadingCache<String, Object> caches = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(10, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Object>() {
					@Override
					public Object load(String key) throws Exception {
						return generateValueByKey(key);
					}
				});
		try {
			caches.put("r", "t");
			Object s = caches.get("r");
			s = "666";
			System.out.println(caches.get("r"));
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	protected static Object generateValueByKey(String key) {
		return "value:" + key;
	}
}
