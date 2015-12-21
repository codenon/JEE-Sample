package cn.conon.j2ee.sample.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//使用meta标签模拟http响应头
public class ResponseDemo8 extends HttpServlet {
	private static final long serialVersionUID = -8785182285220023488L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("gb2312");

		response.getWriter()
				.write("<meta http-equiv='content-type' content='text/html; charset=gb2312'>");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("中国");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
