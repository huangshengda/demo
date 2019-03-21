package main.com.hsd.constructuor;

import java.io.*;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2019/1/7
 */
public class Test {

    public static void main(String[] args) throws Exception{


        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance().clone());

        //System.out.println(Monkey.INSTANCE.hashCode());
        //System.out.println(Monkey.INSTANCE.getName());
        //System.out.println(clone(Monkey.INSTANCE)== Monkey.INSTANCE);


        //System.out.println(Person.getInstance());
        //System.out.println(clone(Person.getInstance()));


        //Person person = new Person();

        //Person person1 = Person.class.newInstance();
        //Class.forName("");

        //Class<?> clazz = Class.forName("com.hsd.demo.constructuor.Person");
        //Constructor<?> constructor = clazz.getConstructor();
        //Constructor<?> constructor = clazz.getDeclaredConstructor(null);
        //constructor.setAccessible(true);
        //Person person = (Person)constructor.newInstance();
        //System.out.println(person.getName());
    }


    //分身技能
    public static Object clone(Object obj){
        //BeanUtils.cloneBean()
        //深度克隆
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //return super.clone();//默认浅克隆，只克隆八大基本数据类型和String
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Object copy = ois.readObject();
            //copy.birthday = new Date();

            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
