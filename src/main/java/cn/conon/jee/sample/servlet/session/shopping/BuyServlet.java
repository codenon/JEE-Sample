package cn.conon.jee.sample.servlet.session.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//完成购买 
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Book book = DB2.find(id);

		// 把用户买的书保存到用户的session中
		HttpSession session = request.getSession();
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60 * 5);
		cookie.setPath("/day07");
		response.addCookie(cookie);

		List cart = (List) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList();
			session.setAttribute("cart", cart);
		}

		cart.add(book);

		String url = response.encodeRedirectURL("/day07/servlet/ListCartServlet");
		response.sendRedirect(url);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
