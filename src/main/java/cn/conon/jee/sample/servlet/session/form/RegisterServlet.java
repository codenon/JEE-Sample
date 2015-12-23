package cn.conon.jee.sample.servlet.session.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (isToken(request) == true) {
			// 是重复提交
			System.out.println("你是重复提交");
			return;
		}

		// 允许提交的时候，记得清除 session 中的随机数
		request.getSession().removeAttribute("token");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("保存用户数据到数据库........");
	}

	private boolean isToken(HttpServletRequest request) {

		String ctoken = request.getParameter("token");
		if (ctoken == null) {
			return true;
		}

		String stoken = (String) request.getSession().getAttribute("token");
		if (stoken == null) {
			return true;
		}

		if (!ctoken.equals(stoken)) {
			return true;
		}

		return false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
