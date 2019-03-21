/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.socket.netty.helloworld;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huangshengda  
 * @date 2017年6月23日   
 * @version  1.0
*/
public class TestBackLog {

	public static void main(String[] args) throws Exception {
		BufferedReader in = null;
		PrintWriter out = null;
		int backlog = 6;

		ServerSocket serversocket = new ServerSocket(8765, backlog);
		while (true) {
			System.out.println("启动服务端......");
			int i;
			Socket socket = serversocket.accept();
			System.out.println("有客户端连上服务端, 客户端信息如下：" + socket.getInetAddress() + " : " + socket.getPort() + ".");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			Thread.sleep(10000);
			do {
				char[] c = new char[1024];
				i = in.read(c);
				System.out.println("服务端收到信息: " + new String(c, 0, i));
			} while (i == -1);
			out.close();
			in.close();
			socket.close();
			System.out.println("关闭服务端......");
		}
	}

}
