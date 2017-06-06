package com.codyy.process;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessUnblock {
	public static void main(String[] args) throws Exception {
		ProcessBuilder builder = new ProcessBuilder();
        List<String> command = new ArrayList<String>();
        command.add("D:\\ffmpeg.exe");
        command.add("-ss");
        command.add("11");
//        command.add("-loglevel");
//        command.add("quiet");
        command.add("-i");
        command.add("D:\\Wildlife.wmv");
        command.add("-vframes");
        command.add("1");
        command.add("-y");
        command.add("-f");
        command.add("image2");
        command.add("D:\\sample2.jpg");
        
        builder.command(command);
        final Process process2 = builder.start();
        
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				process2.destroy();
				System.out.println("==========");
			}
		}).start();
        
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
