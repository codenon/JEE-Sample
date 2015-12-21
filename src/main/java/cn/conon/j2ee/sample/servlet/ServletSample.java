package cn.conon.j2ee.sample.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author codenon
 * @date 2015年12月15日 下午6:25:19
 */
public class ServletSample extends GenericServlet {
	private static final long serialVersionUID = -5007962560985952036L;

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		OutputStream out = res.getOutputStream();
		out.write("hello servlet".getBytes());
	}
}
