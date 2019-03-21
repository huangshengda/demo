package com.hsd.vm;

import java.io.*;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/10/23
 */
public class FileSystemClassLoader extends ClassLoader {

    private String rootDir;
    
    public FileSystemClassLoader(String rootDir){
        this.rootDir = rootDir;
    }
    
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);  // 获取类的字节数组
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }

    }

    private byte[] getClassData(String classname) {
        // 读取类文件的字节
        String path = classnameToPath(classname);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classnameToPath(String classname) {
        return rootDir + File.separatorChar + classname.replace('.',File.separatorChar) + ".class";
    }
}
