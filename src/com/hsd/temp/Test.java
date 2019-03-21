package com.hsd.temp;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/12/29
 */
public class Test {

    public static void main(String[] args) throws Exception {

        System.out.println(MyEnumm.class.getSuperclass());

        /*Object[] objectArray = new Long[1];
        objectArray[0] = "dsd";


        final int value[] = {1,2};
        int val1[] = value;
        val1[0] = 3;
        System.out.println(Arrays.toString(value));
        System.out.println(Arrays.toString(val1));*/

       /* Student student = new Student();
        student.name = "dsad";
        System.out.println(student.name);
        //System.out.println(JSONObject.toJSONString(student));
        String s = "{\"name\":\"aaa\"}";
        System.out.println(JSONObject.parseObject(s, Student.class).name);*/

        /*Class clazz = A.class;
        Constructor constructor1 = clazz.getDeclaredConstructor();
        constructor1.setAccessible(true);
        //Constructor<A> constructor = A.class.getConstructor();

        //constructor1.setAccessible(true);
        A a = (A) constructor1.newInstance();*/

        /*long start = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));*/
        //System.out.println(sum);
        /*Student[] a1 = {new Student("1"), new Student("2")};
        Student[] a2 = a1.clone();
        a2[0] = new Student("3");
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));

        new Student("dsad");*/
    }

}
