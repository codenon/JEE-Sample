package cn.conon.j2ee.sample.servlet.request;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//防盗链的案例
public class RequestDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 是不是从本站点过来的
		String referer = request.getHeader("referer"); // null
														// http://localhost:8080/index.jsp
														// http://www.google.com/index.jsp
		if (referer == null || !referer.startsWith("http://localhost:8080")) {
			response.sendRedirect("/day06/index.html");
			return; // 很重要
		}

		String path = this.getServletContext()
				.getRealPath("/download/人在鸟途.avi");
		File file = new File(path);
		FileInputStream in = new FileInputStream(file);

		OutputStream out = response.getOutputStream();
		byte buffer[] = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		response.setHeader("content-disposition", "attachment;filename="
				+ URLEncoder.encode(file.getName(), "UTF-8"));
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
