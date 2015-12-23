package cn.conon.jee.sample.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.write("������վ��ҳ���ݣ���<br/><br/>");

		// ��cookie
		// 1.����cookie
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		cookie.setMaxAge(0);
		cookie.setPath("/day07");
		// 2.����response��������cookie
		response.addCookie(cookie);

		// ��cookie����ʾ
		// 1.�õ��û���cookie
		Cookie cookies[] = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			Cookie c = cookies[i];
			if (c.getName().equals("lastAccessTime")) { // date
				String value = c.getValue(); // �õ��û��������ʱ��ֵ
				Date d = new Date(Long.parseLong(value));
				out.write("���ϴεķ���ʱ���ǣ�" + d.toLocaleString());
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
