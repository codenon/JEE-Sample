package cn.conon.j2ee.sample.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 1.根据id显示用户想看的书的详细信息
		String id = request.getParameter("id");
		Book book = DB.find(id);
		out.write(book.getId() + "<br/>");
		out.write(book.getName() + "<br/>");
		out.write(book.getAuthor() + "<br/>");
		out.write(book.getPrice() + "<br/>");

		// 2.向用户发cookie

		// 构建cookie bookHistory=2_4_1
		String bookHistory = makeCookie(request, id);
		Cookie cookie = new Cookie("bookHistory", bookHistory);

		// 发送
		response.addCookie(cookie);

	}

	private String makeCookie(HttpServletRequest request, String id) {

		// bookHistory=null 1 bookHistory=1
		// bookHistory=2_3_1 1 bookHistory=1_2_3
		// bookHistory=3_2_5 1 bookHistory=1_3_2
		// bookHistory=2_3 1 bookHistory=1_2_3

		String bookHistory = null;
		Cookie cookies[] = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("bookHistory")) {
				bookHistory = cookies[i].getValue();
			}
		}

		if (bookHistory == null) {
			bookHistory = id;
			return bookHistory;
		}

		// 看用户带过来的cookie里面有没有包含当前id : 2_3_1 1
		String ids[] = bookHistory.split("\\_");
		List l = Arrays.asList(ids); // [1,2,3] 1
		LinkedList<String> list = new LinkedList();
		list.addAll(l);

		if (list.contains(id)) { // [3,1,2] 1 ---> [1,3,2]
			list.remove(id);
			list.addFirst(id);
		} else if (list.size() >= 3) { // [3,4,5] 1 ---> [1,3,4]
			list.removeLast();
			list.addFirst(id);
		} else { // [3,4] 1 ---> [1,3,4]
			list.addFirst(id);
		}

		// 程序到此，list集合保存就是最新的 cookie值，再就是取list里面的值，变成3_1_4
		StringBuffer sb = new StringBuffer();
		for (String lid : list) {
			sb.append(lid + "_");
		}
		return sb.deleteCharAt(sb.length() - 1).toString();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
