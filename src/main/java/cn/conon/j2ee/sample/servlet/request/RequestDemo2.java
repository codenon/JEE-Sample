package cn.conon.j2ee.sample.servlet.request;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

//获取客户机请求参数
public class RequestDemo2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getRemoteAddr());

		// 方式1： http://localhost:8080/day06/servlet/RequestDemo2?name=aaa
		String name = request.getParameter("name");
		System.out.println(name);
		System.out
				.println("------------------------------------------------------\r\n\r\n");

		// 方式2：
		// http://localhost:8080/day06/servlet/RequestDemo2?like=sing&like=dance
		String likes[] = request.getParameterValues("like");
		for (String like : likes)
			System.out.println(like);
		System.out
				.println("------------------------------------------------------\r\n\r\n");

		// 方式3：
		// http://localhost:8080/day06/servlet/RequestDemo2?like=sing&name=aaa
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String ename = (String) e.nextElement();
			String value = request.getParameter(ename);
			System.out.println(ename + "=" + value);
		}
		System.out
				.println("------------------------------------------------------\r\n\r\n");

		// 方式4：
		// http://localhost:8080/day06/servlet/RequestDemo2?like=sing&like=dance&name=aaa
		Map<String, String[]> map = request.getParameterMap();
		for (Map.Entry<String, String[]> me : map.entrySet()) {
			String mname = me.getKey();
			String values[] = me.getValue();
			for (String value : values) {
				System.out.println(mname + "=" + value);
			}
		}

	}

	// getParameterNames()方法的应用场景
	@SuppressWarnings("unused")
	private User save(HttpServletRequest request)
			throws IllegalAccessException, InvocationTargetException {

		User user = new User();
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			BeanUtils.setProperty(user, name, request.getParameter("name"));
		}
		return user;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
