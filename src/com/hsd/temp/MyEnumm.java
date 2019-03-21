package com.hsd.temp;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2019/1/18
 */
public enum MyEnumm {
    BLACK {
        @Override
        void test(String name) {
            test1();
        }
    };


    abstract void test(String name);


    void test1(){

    }
    public static void main(String[] args){
        BLACK.test("佩奇");
    }

}
