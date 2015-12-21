package cn.conon.j2ee.sample.servlet.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//乱码问题
public class RequestDemo6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 为了获取中文数据时不出现乱码，request需要根据客户端提交的数据的编码，来设置相应的码表
		// 即：客户机提交的是gb2321的中国，request也要设置为gb2312码表
		request.setCharacterEncoding("gb2312");
		String name = request.getParameter("username");

		// 中国
		response.setCharacterEncoding("gb2312"); // 98 99
		response.setContentType("text/html;charset=gb2312");
		response.getWriter().write(name);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
