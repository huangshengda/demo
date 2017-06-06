package com.codyy.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

public class ProcessDemo {
	public synchronized void lookDirectory() throws Exception {// 查看目录
        ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "dir"); // 创建进程管理实例，查看目录
        builder.directory(new File("D:/")); // 查看的目录
        Process process = builder.start(); // 启动进程
        InputStream is = process.getInputStream(); // 获得输入流
        InputStreamReader isr = new InputStreamReader(is, "GBK");// 创建输入读流，编码方式为GBK
        BufferedReader br = new BufferedReader(isr); // 创建读缓冲对象
        String line;
        while ((line = br.readLine()) != null) {// 循环读取数据
            System.out.println(line);
        }
    }
 
    public synchronized void setEnvironment() throws Exception {// 设置环境变量
        ProcessBuilder pb = new ProcessBuilder("cmd.exe");// 创建进程管理实例
        // 获取系统参数并打印显示
        Map<String, String> env = pb.environment();
        env.put("key1", "value2");// 设置环境变量
        env.put("key2", "value2");
        env.remove("key2");// 移除环境变量
        Iterator it = env.keySet().iterator();// 根据键值获得集合
        // 遍历集合显示系统变量
        while (it.hasNext()) {
            System.out.println("系统变量:" + ((String) it.next()) + "=" + env.get(it.next()));
        }
        // pb.directory(new File("D:/temp"));// 设置工作目录
        pb.start();// 启动进程
    }
 
    public synchronized void lookPhysicalAddress() throws Exception {// 查看物理地址
        try {
            ProcessBuilder pb = new ProcessBuilder("ipconfig", "/all");// 创建进程管理实例
            Process process = pb.start();// 启动进程
            byte[] b = new byte[1024];// 创建字节数组
            StringBuffer sb = new StringBuffer();// 创建缓冲字符串
            InputStream is = process.getInputStream(); // 获得输入流
            InputStreamReader isr = new InputStreamReader(is, "GBK");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {// 循环读取数据
                if (line.indexOf("IPv4") != -1)
                    System.out.println(line);
            }
            is.close();
            isr.close();
            br.close();
        } catch (Exception e) {// 捕获异常
            e.printStackTrace();
        }
    }
 
    public synchronized void openWNWB() throws Exception {// 启动WinRAR
        ProcessBuilder p = new ProcessBuilder("C:\\Program Files\\WinRAR\\WinRAR.exe");// 创建进程管理实例
        p.start();// 启动进程
    }
 
    public static void main(String[] args) throws Exception {// java程序主入口处
        ProcessDemo execute = new ProcessDemo();// 创建实例
        System.out.println("1.查看目录");
        execute.lookDirectory();// 调用方法查看目录
        System.out.println("2.设置查看环境变量");
        //execute.setEnvironment();// 调用方法设置变量
        System.out.println("3.查看IP地址");
        execute.lookPhysicalAddress();// 调用方法查看IP地址
        System.out.println("4.启动WinRAR程序");
        //execute.openWNWB();
    }
}
