package cn.conon.jee.sample.servlet.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//获取表单数据的小细节：在获取表单数据时，一定要考虑到一些异常情况（包括null 和 ""）
public class RequestDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username"); // ""

		// 要判断用户是否提交数据过来了，判断代码的写法
		if (username != null && !username.trim().equals("")) {
			// 才能确认用户带数据过来了
		} else {
			// 用户没有带数据过来
		}

		String gender = request.getParameter("gender"); // null
		System.out.println(gender);

		String likes[] = request.getParameterValues("like");
		System.out.println(likes);
		for (int i = 0; likes != null && i < likes.length; i++) {
			System.out.println(likes[i]);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
