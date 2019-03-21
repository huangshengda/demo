package main.com.codyy.thread;

import java.util.Random;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author huangshengda  
 * @date 2017年3月8日   
 *  
*/
public class ThreadDemo implements Runnable {

	private final static ThreadLocal studentLocal = new ThreadLocal();

	private int count = 0;

	// Student student = new Student();

	public static void main(String[] agrs) {

		// Class.forName("aaa");
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(System.getProperty("java.class.path"));

		ThreadDemo td = new ThreadDemo();
		Thread t1 = new Thread(td, "a");
		Thread t2 = new Thread(td, "b");
		t1.start();
		t2.start();

	}

	/* (non-Javadoc) 
	 * @see java.lang.Runnable#run() 
	 */
	public void run() {
		accessStudent();
	}

	public void accessStudent() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running!");

		try {
			this.count++;
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("thread " + currentThreadName + " read count:" + this.count);
		// System.out.println("first read age is:"+this.student.getAge());
		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println("thread " + currentThreadName + " set age to:" + age);

		Student student = getStudent();
		student.setAge(age);

		System.out.println("thread " + currentThreadName + " first  read age is:" + student.getAge());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("thread " + currentThreadName + " second read age is:" + student.getAge());

	}

	protected Student getStudent() {
		Student student = (Student) studentLocal.get();
		if (student == null) {
			student = new Student();
			studentLocal.set(student);
		}
		return student;
	}

	protected void setStudent(Student student) {
		studentLocal.set(student);
	}
}
