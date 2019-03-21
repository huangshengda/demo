package com.hsd.serializable;

import java.io.*;

public class MyMain {
	public static void main(String[] args) throws Exception {
		//seriliablePerson();
		deSeriliablePerson();
	}

	private static void seriliablePerson() throws IOException {
		File file = new File("D:\\temp\\person");
		// 序列化持久化对象
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		Person person = new Person("Peter", 27);
		out.writeObject(person);
		out.close();
	}

	private static void deSeriliablePerson() throws IOException, ClassNotFoundException {
		File file = new File("D:\\temp\\person");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Person newPerson = (Person)in.readObject(); // 没有强制转换到Person类型
		in.close();
		System.out.println(newPerson);
	}
}
