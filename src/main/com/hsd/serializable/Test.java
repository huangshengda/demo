/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**  
 * @Description: Test
 * @author huangshengda  
 * @date 2017年12月15日   
 * @version  1.0
*/
public class Test {
	public static void main(String[] args) {
		Person p = new Person("Jack", "22");
		File file = new File("e:\\p\\persion.txt");

		try {
			// file.createNewFile();
			// Student对象序列化过程
			/*FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(p);
			oos.flush();
			oos.close();
			fos.close();*/

			// Student对象反序列化过程
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Person st1 = (Person) ois.readObject();
			System.out.println("phone = " + st1.getName());
			System.out.println(st1);
			ois.close();
			fis.close();
			/*FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student st1 = (Student) ois.readObject();
			System.out.println("phone = " + st1.getPhone());
			ois.close();
			fis.close();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
