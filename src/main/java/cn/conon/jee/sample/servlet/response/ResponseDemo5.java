package cn.conon.jee.sample.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//response注意事项：text/html，charset=UTF-8 （，号是错的）
public class ResponseDemo5 extends HttpServlet {
	private static final long serialVersionUID = -3756318073499591571L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data = "中国";

		response.setCharacterEncoding("UTF-8");

		// 注意text/html，charset=UTF-8 ,','不要出现
		response.setHeader("content-type", "text/html;charset=UTF-8");

		response.getWriter().write(data);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
