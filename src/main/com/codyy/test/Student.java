package main.com.codyy.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author huangshengda  
 * @date 2017年2月14日   
 *  
*/
public class Student {

	private int age;

	public Student(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		Student s1 = new Student(1);
		System.out.println(s1);
		Student s2 = new Student(2);

		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getAge() > o2.getAge() ? -1 : 1;
			}

		});
		System.out.println(list);
		System.out.println(1 << 4);

		Map<String, String> map = new HashMap<String, String>();
		map.entrySet();
		map.keySet();
		System.currentTimeMillis();
	}
}
