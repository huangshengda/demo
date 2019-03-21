package main.com.hsd.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/12/19
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*FutureTask task = new FutureTask(new Callable<String>() {
            @Override
            public String call() {

                String s = null;
                try {
                    System.out.println("aaa");
                    s = "aaa";
                    s.equals("ll");
                    s.substring(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return s;
            }
        });
        task.run();*/
        //System.out.println("out: " + task.get(1, TimeUnit.SECONDS));

    }

}
