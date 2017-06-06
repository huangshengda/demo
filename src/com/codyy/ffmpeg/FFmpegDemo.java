package com.codyy.ffmpeg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FFmpegDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("ipconfig", "/all");// 创建进程管理实例
        Process process = pb.start();// 启动进程
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
        
        ProcessBuilder builder = new ProcessBuilder();
        List<String> command = new ArrayList<String>();
        command.add("D:\\ffmpeg.exe");
        command.add("-ss");
        command.add("11");
        command.add("-loglevel");
        command.add("quiet");
        command.add("-i");
        command.add("D:\\Wildlife.wmv");
        command.add("-vframes");
        command.add("1");
        command.add("-y");
        command.add("-f");
        command.add("image2");
        command.add("D:\\sample2.jpg");
        
        builder.command(command);
        Process process2 = builder.start();
        System.out.println(process2.waitFor());
        
        InputStream is2 = process2.getErrorStream();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
        StringBuilder buf = new StringBuilder(); // 保存输出结果流
        String line2 = null;
        while((line2 = br2.readLine()) != null){
        	buf.append(line2); // 循环等待ffmpeg进程结束
        }
        System.out.println("输出结果为：" + buf);
        
	}
}
