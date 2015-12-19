package cn.conon.jee.sample.servlet.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//请求转发 
public class RequestDemo8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.通过request实现请求转发
		// 2.通过servletContext实现请求转发 两种方式一样

		// forward之前写入客户机数据，是不会输出的
		PrintWriter out = response.getWriter();
		out.write("abc");

		String data = request.getParameter("data");
		request.setAttribute("data", data);

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

		// forward之后写入客户机数据，也是不会输出的
		out.write("bcd");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
