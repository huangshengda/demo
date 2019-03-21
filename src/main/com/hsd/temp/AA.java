package main.com.hsd.temp;

import java.io.*;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2019/1/18
 */
public class AA extends A implements Serializable {

    private String name;

    public AA(String a){
        super(a);
    }

    public static void main(String[] args) throws Exception {
       AA aa =  new AA("");
       ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\test.txt"));
        oos.writeObject(aa);
    }

}
