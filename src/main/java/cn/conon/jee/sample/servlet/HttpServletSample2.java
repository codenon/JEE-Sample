package cn.conon.jee.sample.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletSample2 extends HttpServlet {
	private static final long serialVersionUID = -4830478104165359111L;
	private transient ServletConfig config;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		servletConfig();
		config();
		servletConfigUse();
		servletContext(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/** servletConfig 获取servlet配置的初始化参数 **/
	private void servletConfig() {
		System.out.println("-----------------------------------------------");

		String servletName = config.getServletName();
		System.out.println(servletName);

		ServletContext servletContext = config.getServletContext();
		System.out.println(servletContext);

		String value = config.getInitParameter("name");
		System.out.println(value);

		Enumeration<String> e = config.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			value = config.getInitParameter(name);
			System.out.println(name + "=" + value);
		}
	}

	/** 获取servlet配置的初始化参数 **/
	private void config() {
		System.out.println("-----------------------------------------------");

		String servletName = this.getServletName();
		System.out.println(servletName);

		ServletContext servletContext = this.getServletContext();
		System.out.println(servletContext);

		String value = this.getInitParameter("name");
		System.out.println(value);

		Enumeration<String> e = this.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			value = config.getInitParameter(name);
			System.out.println(name + "=" + value);
		}
	}

	/** serlvetConfig应用 **/
	private void servletConfigUse() {
		System.out.println("-----------------------------------------------");
		// servletConfig的应用1：获取到输出的编码
		ServletConfig config = getServletConfig();
		String enocding = config.getInitParameter("encoding");

		System.out.println("enocding=" + enocding);

		System.out.println("-----------------------------------------------");

		String url = null;
		String username = null;
		String password = null;

		// servletConfig的应用2：从配置文件中获取连接数据库的信息
		url = this.getServletConfig().getInitParameter("url");
		username = this.getServletConfig().getInitParameter("username");
		password = this.getServletConfig().getInitParameter("password");

		System.out.println(url + "---" + username + "----" + password);
	}

	/**
	 * servletContext应用
	 * 
	 * @throws IOException
	 * @throws ServletException
	 **/
	private void servletContext(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// servletContext案例:多个servlet共享数据
		System.out.println("-----------------------------------------------");
		getServletContext().setAttribute("name", "xxxx");
		System.out.println(getServletContext().getAttribute("name"));

		// servletContext应用：通过servletContext拿到整个web应用初始化参数
		System.out.println("-----------------------------------------------");
		ServletContext context = this.getServletContext();
		String url = context.getInitParameter("url");
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");

		System.out.println("url=" + url);
		System.out.println("username=" + username);
		System.out.println("password=" + password);

		// servletContext应用：实现web资源的转发
		System.out.println("-----------------------------------------------");

		String data = "abcd";

		// PrintWriter out = response.getWriter();
		// out.write("<h2><font color='red'>" + data + "</font></h2>");

		// ServletContext context = this.getServletContext();
		context.setAttribute("data", data);
		RequestDispatcher rd = context.getRequestDispatcher("/view.jsp");
		rd.forward(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
	}
}
