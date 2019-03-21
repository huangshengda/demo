package main.com.hsd.constructuor;

import java.io.Serializable;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2019/1/7
 */
public class Person implements Serializable, Cloneable{

    private String name;

    private Integer age;

    private static boolean flag = true;

    private Person() {
        synchronized (Person.class){
            if(flag){
                flag = false;
                System.out.println("person constructor");
                this.name = "sea king";
            }else{
                //throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private static class InnerClass{
        public static final Person instance  = new Person();
    }

    public static Person getInstance(){
        return InnerClass.instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
