package com.hsd.temp;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/12/29
 */
public final class  Student implements Person {

    String name;

    int ordinal;



    public Student(String name, int ordinal){
        this.name = name;
        this.ordinal = ordinal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public static void main(String[] args){
        System.out.println(JSONObject.toJSONString(new Student("BLACK", 1)));
    }


}
