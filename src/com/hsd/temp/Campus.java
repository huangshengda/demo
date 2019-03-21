package com.hsd.temp;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2019/1/13
 */
public class Campus {

    private static String ff;

    private String name;

    private String loc;


    public Campus(String ff) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ff = ff;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Campus("q");
                System.out.println(1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Campus("e");
                System.out.println("2");
            }
        }).start();
        System.out.println("finish");
        //Thread.sleep(1000000000);
    }


}
