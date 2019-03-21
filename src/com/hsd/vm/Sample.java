package com.hsd.vm;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/10/23
 */
public class Sample {
    private Sample instance;

    public void setSample(Object instance) {
        System.out.println(instance.toString());
        this.instance = (Sample) instance;
    }
}
