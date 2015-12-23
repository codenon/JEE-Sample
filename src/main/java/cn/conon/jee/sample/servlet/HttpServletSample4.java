package cn.conon.jee.sample.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

//用类装载器的方式读取资源文件
public class HttpServletSample4 extends HttpServlet {

	private static final long serialVersionUID = -4380332908461547608L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		douu();

	}

	// 用类装载器的方式读取classes目录下面的资源文件
	@SuppressWarnings("unused")
	private void doxx() throws IOException {
		InputStream in = HttpServletSample4.class.getClassLoader()
				.getResourceAsStream("db.properties");
		Properties prop = new Properties();
		prop.load(in);
		String url = prop.getProperty("url");
		System.out.println(url);
	}

	// 用类装载器的方式读取classes目录下包下面的资源文件 ：cn.itcast.servlet
	@SuppressWarnings("unused")
	private void dozz() throws IOException {
		InputStream in = HttpServletSample4.class.getClassLoader()
				.getResourceAsStream("cn/itcast/servlet/db.properties");
		Properties prop = new Properties();
		prop.load(in);
		String url = prop.getProperty("url");
		System.out.println(url);
	}

	// 把资源文件当成url来对待
	@SuppressWarnings("unused")
	private void doyy() throws IOException {
		URL url = HttpServletSample4.class.getClassLoader().getResource(
				"db.properties");
		System.out.println(url.getPath());

		FileOutputStream out = new FileOutputStream(url.getPath());
		out.write("abc".getBytes());
		out.close();
	}

	// 用类装载器的方式读取资源文件要注意的事情:资源文件不能太大
	public void douu() {
		// InputStream in =
		// HttpServletSample4.class.getClassLoader().getResourceAsStream("06.avi");
		InputStream in = this.getServletContext().getResourceAsStream(
				"/WEB-INF/classes/06.avi");
		IOUtils.closeQuietly(in);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
