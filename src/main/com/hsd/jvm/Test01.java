package main.com.hsd.jvm;

public class Test01 {

	public static void main(String[] args) {

		// -Xms5m -Xmx20m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags
		/*System.gc();
		// 查看GC信息
		System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
		System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
		System.out.println("total memory:" + Runtime.getRuntime().totalMemory());
		
		byte[] b1 = new byte[1 * 1024 * 1024];
		System.out.println("分配了1M");
		System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
		System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
		System.out.println("total memory:" + Runtime.getRuntime().totalMemory());
		
		byte[] b2 = new byte[4 * 1024 * 1024];
		System.out.println("分配了4M");
		System.out.println("max memory:" + Runtime.getRuntime().maxMemory());
		System.out.println("free memory:" + Runtime.getRuntime().freeMemory());
		System.out.println("total memory:" + Runtime.getRuntime().totalMemory());*/

		long begin = 0x00000000f9a00000;
		long end = 0x00000000f9bc0000;

		long diff = end - begin;
		long n = 0x00000000fa0a0000;
		System.out.println(begin);
		System.out.println(end);

		System.out.println(diff);
		System.out.println(n);

	}

}
