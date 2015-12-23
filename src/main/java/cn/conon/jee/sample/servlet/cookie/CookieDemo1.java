package cn.conon.jee.sample.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//代表网站首页的servlet
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 1.向用户输出网站所有的商品
		out.write("本网站有如下商品：<br/>");
		Map<String, Book> map = DB.getBooks();
		for (Map.Entry<String, Book> me : map.entrySet()) {
			String id = me.getKey();
			Book book = me.getValue();
			out.write("<a href='/day07/servlet/CookieDemo2?id=" + book.getId() + "' target='_blank'>" + book.getName() + "</a><br/>");
		}

		// 2.得到用户的cookie，显示用户曾经浏览过的商品
		out.write("<br/><br/>"); // bookHistory=2_3_1 2.3.1
		out.write("您曾经浏览过的商品：<br/>");

		Cookie cookies[] = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("bookHistory")) {
				String ids[] = cookie.getValue().split("\\_");
				for (String id : ids) {
					Book book = DB.find(id);
					out.write(book.getName() + "<br/>");
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

// 模似一个数据库，它里面有个map集合用于保存网站所有的书
class DB {
	private static Map<String, Book> map = new LinkedHashMap<String, Book>();
	static {
		map.put("1", new Book("1", "javaweb开发", "张孝祥", "39"));
		map.put("2", new Book("2", "spring开发", "廖雪峰", "49"));
		map.put("3", new Book("3", "hibernate开发", "李勇", "69"));
		map.put("4", new Book("4", "struts开发", "张孝祥", "29"));
		map.put("5", new Book("5", "ajax开发", "王兴魁", "49"));
	}

	public static Map<String, Book> getBooks() {
		return map;
	}

	public static Book find(String id) {
		return map.get(id);
	}

}

class Book {
	private String id;
	private String name;
	private String author;
	private String price;

	public Book() {

	}
	public Book(String id, String name, String author, String price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
