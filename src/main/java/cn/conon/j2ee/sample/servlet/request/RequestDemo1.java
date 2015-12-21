package cn.conon.j2ee.sample.servlet.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//request对象的常用方法
public class RequestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.得到请求方式
		String method = request.getMethod();
		System.out.println(method);
		System.out
				.println("------------------------------------------------------\r\n\r\n");

		// 2.得到请求头
		String head = request.getHeader("host");
		System.out.println(head);
		System.out
				.println("------------------------------------------------------\r\n\r\n");

		// 3.得到web应用的名称
		String contextpath = request.getContextPath();
		System.out.println(contextpath); // 应用场景response.sendRedirect(contextpath
											// + "/index.jsp");
		System.out
				.println("------------------------------------------------------\r\n\r\n");

		// 4.得到查询字符串
		System.out.println(request.getQueryString());
		System.out
				.println("------------------------------------------------------\r\n\r\n");

		// 5.得到请求的uri和url(即客户机要访问的资源)
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out
				.println("------------------------------------------------------\r\n\r\n");

		// 6.得到来访问者的ip
		System.out.println(request.getRemoteAddr());
		System.out
				.println("------------------------------------------------------\r\n\r\n");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
