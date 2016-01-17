package cn.conon.jee.sample.ajax.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.converters.DateConverter;

public class ValidateBirthServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String birth = request.getParameter("birth");
		DateConverter dc = new DateConverter();
		dc.setPattern("yyyy-MM-dd");

		String result = null;
		try {
			dc.convert(Date.class, birth);
			result = "<font color='green'>You have entered a valid birth</font>";
		} catch (Exception e) {
			result = "<font color='red'>You have entered an invalid birth</font>";
		}

		response.setContentType("text/html");
		response.getWriter().print(result);
	}

}
