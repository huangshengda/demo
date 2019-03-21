package main.com.hsd.constructuor;

import java.io.Serializable;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2019/1/8
 */
public enum  Monkey implements Serializable, Cloneable{

    INSTANCE;

    private Integer age = 2;
    private String name = "kk";

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
