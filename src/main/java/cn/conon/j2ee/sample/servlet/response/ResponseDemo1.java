package cn.conon.j2ee.sample.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1 extends HttpServlet {

	private static final long serialVersionUID = 9029624010370544520L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 如果数据是字符数据，调用getWriter或getOutputStream
		String data = "abc";
		// 为数据设置合理的缓存时间值
		response.setDateHeader("expires", System.currentTimeMillis() + 365 * 24
				* 60 * 60 * 1000);
		response.getWriter().write(data); // abc
		response.getOutputStream().write(data.getBytes()); // 97 98 99

		// response.getWriter().write("<br/>");
		// 如果数据是字节数据，调用getOutputStream
		// byte b[] = {98,99};
		// response.getOutputStream().write(b); //bc

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
