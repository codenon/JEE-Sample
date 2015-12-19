package cn.conon.jee.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//关于程序路径的servlet
public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 用到路径的几个场景

		// 1.转发
		request.getRequestDispatcher("/index.jsp").forward(request, response);

		// 2.重定向
		response.sendRedirect("/day06/index.jsp");

		// 3.获取服务器某个资源
		this.getServletContext().getResourceAsStream("/download/1.txt");

		// 如何在程序中指定路径
		// 1.但凡在程序需要写路径，通通要以"/"开头
		// 2。如果"/"是给服务器用的，那就代表web工程
		// 3.如果"/"是给服务器用的，那就代表webapps

		//

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
