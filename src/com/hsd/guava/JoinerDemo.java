package com.hsd.guava;

import com.google.common.base.Joiner;

import java.util.HashMap;
import java.util.Map;

public class JoinerDemo {
	public static void main(String[] args) {
		Map<String,String>map=new HashMap<String,String>();
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		System.out.println(Joiner.on(",").withKeyValueSeparator("=").join(map));
	}

}
