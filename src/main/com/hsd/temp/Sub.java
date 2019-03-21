package main.com.hsd.temp;

import java.util.Date;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2019/1/16
 */
public class Sub extends Super {

    private final Date date;

    Sub(){
        date = new Date();
    }

    @Override
    public void myFuc() {
        System.out.println(date);
    }

    public static void main(String[] args){
        Sub sub = new Sub();
        sub.myFuc();
    }

}
