package cn.conon.jee.sample.servlet.request;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//获取客户机数据的案例
public class RequestDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/***********************************************************************
		 * 服务器想收集客户端的数据： 1、通过超链接后面的参数收集 2、收到向客户机输出表单收集
		 * 
		 **********************************************************************/

		// 获取客户端通过超链接带过来的数据
		System.out.println(request.getParameter("name"));

		String username = request.getParameter("username");
		System.out.println(username);

		String password = request.getParameter("password");
		System.out.println(password);

		String gender = request.getParameter("gender");
		System.out.println(gender);

		String likes[] = request.getParameterValues("like");
		System.out.println(Arrays.asList(likes));

		String city = request.getParameter("city");
		System.out.println(city);

		String resume = request.getParameter("resume");
		System.out.println(resume);

		// 获取 隐藏输入项的值
		String value = request.getParameter("aaa");
		System.out.println(value);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
