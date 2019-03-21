package main.com.hsd.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTest {

	public static void main(String[] args) {
		SoftReference<String> sr = new SoftReference<String>(new String("hello"));
		System.gc();
		System.out.println(sr.get());
	
		WeakReference<String> sc = new WeakReference<String>(new String("hello"));
        System.out.println(sc.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sc.get());
        
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
        System.out.println(pr.get());
	}
}
