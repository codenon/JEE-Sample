package cn.conon.j2ee.sample.servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class HttpServletSample3 extends HttpServlet {

	private static final long serialVersionUID = -3098451475108220653L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	// 传统方式读取：资源文件要bin/classes/db.properties
	@SuppressWarnings("unused")
	private void doxx() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(
				"classes/db.properties"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		IOUtils.closeQuietly(br);
		System.out.println("------------------------------------------------");
	}

	// 用servletContext去classes目录下面读取资源文件
	@SuppressWarnings("unused")
	private void doyy() throws IOException {
		InputStream in = this.getServletContext().getResourceAsStream(
				"/WEB-INF/classes/db.properties");
		Properties prop = new Properties();
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

	// 用servletContext去读取web工程下面的download目录下的文件
	@SuppressWarnings("unused")
	private void dozz() throws IOException {

		InputStream in = this.getServletContext().getResourceAsStream(
				"/download/db.properties");
		Properties prop = new Properties();
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

	// 用servletContext向资源文件中写数据，（download目录下的text文件）
	public void write() throws IOException {
		// 1.获取到要写入资源的位置
		String path = this.getServletContext()
				.getRealPath("/download/test.txt");
		FileWriter writer = new FileWriter(path);
		writer.write("abcd");
		writer.close();
	}

	// 用url对象去获取资源文件数据
	public void read() throws IOException {
		// 用servletContext向download目录下的text文件中写入数据
		// 1.获取资源的URL
		URL url = this.getServletContext().getResource("/download/test.txt");
		InputStream in = url.openStream();
		IOUtils.closeQuietly(in);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
