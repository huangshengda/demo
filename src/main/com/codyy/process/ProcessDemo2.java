package main.com.codyy.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessDemo2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						test();
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
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
	
	public static void test() throws IOException, InterruptedException{
		ProcessBuilder builder = new ProcessBuilder();
        List<String> command = new ArrayList<String>();
        command.add("D:\\ffmpeg.exe");
        command.add("-ss");
        command.add("11");
        command.add("-i");
        command.add("D:\\Wildlife.wmv");
        command.add("-vframes");
        command.add("1");
        command.add("-y");
        command.add("-f");
        command.add("image2");
        command.add("D:\\imgs\\sample"+Thread.currentThread().getId()+".jpg");
        
        builder.command(command);
        Process process2 = builder.start();
        if(process2.waitFor()!=0){
        	System.out.println("执行失败"+Thread.currentThread().getName());
        }else{
        	System.out.println("执行成功"+Thread.currentThread().getName());
        }
	}
}
