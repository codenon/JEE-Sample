package cn.conon.j2ee.sample.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//对于中文数据，应该如何写出
public class ResponseDemo2 extends HttpServlet {
	private static final long serialVersionUID = -3926616144878345895L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data = "中国"; // --->iso8859-1

		// 1.更改response的码表,让response收到中文数据时，采用正确码表对数据进行转换再打给客户机
		response.setCharacterEncoding("UTF-8"); //

		// 2.设置相应的头，控制浏览器以相应的码表显示数据
		// response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		response.getWriter().write(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
