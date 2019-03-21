package com.hsd.classloader;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/12/18
 */
public class OuterClass {
    public static long OUTER_DATE = System.currentTimeMillis();

    static {
        System.out.println("外部类静态块加载时间：  " + System.currentTimeMillis());
    }

    public OuterClass() {
        timeElapsed();
        System.out.println("外部类构造函数时间：   " + System.currentTimeMillis());
    }

    static class InnerStaticClass {
        public static long INNER_STATIC_DATE = System.currentTimeMillis();
    }

    class InnerClass {
        public long INNER_DATE = 0;
        public InnerClass() {
            System.out.println("内部类构造函数加载时间:  " + System.currentTimeMillis());
            timeElapsed();
            INNER_DATE = System.currentTimeMillis();
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        System.out.println("外部类静态变量加载时间：" + outer.OUTER_DATE);
        System.out.println("静态内部类加载时间：   "+ InnerStaticClass.INNER_STATIC_DATE);
        System.out.println("非静态内部类加载时间   "+outer.new InnerClass().INNER_DATE);
    }

    //单纯的为了耗时，来扩大时间差异
    private void timeElapsed() {
        try {
            Thread.sleep(9999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
