package com.hsd.guava;

import com.google.common.base.CharMatcher;
import com.google.common.collect.*;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GuavaTest {

	public static void main(String[] args) {
		List<Integer> list = Lists.newArrayList();
		List<Integer> list1 = new ArrayList<Integer>();

		List<String> exactly100 = Lists.newArrayListWithCapacity(100);

		Set<String> set = Sets.newHashSet();
		Map<String, String> map = Maps.newHashMap();
		// 不变Collection的创建
		ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
		ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
		ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");

		String s2 = CharMatcher.digit().removeFrom("abc 123 efg");
		System.out.println(s2);

		System.out.println("");

		Boolean b = null;
		if (b == null && !b) {
			System.out.println("yyy");
		}

		Object obj = new Object();
		WeakReference<Object> wf = new WeakReference<Object>(obj);
	}
}
