package com.codyy.filedownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downLoad.do")
public class FileDownLoad extends HttpServlet {

	private static final long serialVersionUID = 4692563404102721671L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File file = new File("C:/Users/renguangyuan/Downloads/ideaIC-2016.2.4.exe");

		FileInputStream fis = new FileInputStream(file);

		long p = 0;
		long filelength = 0;

		filelength = file.length();

		if (req.getHeader("Range") != null) {
			resp.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
			p = Long.parseLong(req.getHeader("Range").replaceAll("bytes=", "").replaceAll("-", ""));
		}
		
		resp.reset();
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Accept-Ranges", "bytes");
		resp.setHeader("Content-Length", new Long(filelength - p).toString());

		if (p != 0) {
			resp.setHeader("Content-Range", "bytes " + new Long(p).toString() + "-" + new Long(filelength - 1).toString() + "/"
					+ new Long(filelength).toString());
		}

		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes(),"ISO-8859-1"));

		fis.skip(p);

		byte[] b = new byte[1024];
		int i;

		while ((i = fis.read(b)) != -1) {
			resp.getOutputStream().write(b, 0, i);
		}
		
		fis.close();
	}

}
