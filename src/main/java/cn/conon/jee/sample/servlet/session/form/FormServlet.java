package cn.conon.jee.sample.servlet.session.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

//产生表单
public class FormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String token = TokenProccessor.getInstance().makeToken();
		request.getSession().setAttribute("token", token);
		out.println("<form action='/day07/servlet/RegisterServlet' method='post'>");
			out.println("<input type='hidden' name='token' value='"+token+"'>");  //令牌
			out.println("用户名：<input type='text' name='username'><br/>");
			out.println("密码：<input type='password' name='password'><br/>");
			out.println("<input type='submit' value='提交'>");
		out.println("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}

class TokenProccessor{
	//1.把类的构造方法私有
	//2.类自己创建一个自己的对象
	//3.定义一个方法，允许别人调用这个方法得到对象
	
	
	private TokenProccessor(){}
	private static TokenProccessor instance = new TokenProccessor();
	public static TokenProccessor getInstance(){
		return instance;
	}
	
	public String makeToken(){
		
		//232832 23823823872382 1212
		String token = System.currentTimeMillis() + new Random().nextInt(19999999) + "";
		//数据指纹
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());  //16
			
			//base64编码
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}

