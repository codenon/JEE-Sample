package cn.conon.jee.sample.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//定时刷新
public class ResponseDemo7 extends HttpServlet {
	private static final long serialVersionUID = 2416888302361595994L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 对于get方式提交的数据，设置request码表是无效的，要想不乱码，我们只能手工进行转换
		request.setCharacterEncoding("gb2312");
		String username = request.getParameter("username");
		System.out.println(username);

		// 手工进行转换
		byte source[] = username.getBytes("iso8859-1"); // [98 99]
		username = new String(source, "gb2312");
		System.out.println(username);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
