package cn.conon.j2ee.sample.servlet.session.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = Db.find(username, password);
		if(user==null){
			response.getWriter().write("用户名或密码错误！！");
		}else{
			
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/day07/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}

class Db{
	
	private static Map map = new HashMap();
	static{
		map.put("aaa", new User("aaa","123"));
		map.put("bbb", new User("bbb","123"));
		map.put("ccc", new User("ccc","123"));
	}
	
	public static User find(String username,String password){
		
		User user = (User) map.get(username);
		if(user!=null && user.getPassword().equals(password)){
			return user;
		}
		return null;
		
	}
	
}


