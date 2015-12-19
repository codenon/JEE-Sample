package cn.conon.jee.sample.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//请求重定向
public class ResponseDemo9 extends HttpServlet {
	private static final long serialVersionUID = 6358010276604365389L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 重定向的实现1
		// response.setStatus(302);
		// response.setHeader("location", "/day06/index.html");

		// 重定向的实现2
		response.sendRedirect("/day06/index.html");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
