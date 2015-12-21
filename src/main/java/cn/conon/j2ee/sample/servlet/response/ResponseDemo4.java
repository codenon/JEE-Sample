package cn.conon.j2ee.sample.servlet.response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//下载1.txt
public class ResponseDemo4 extends HttpServlet {
	private static final long serialVersionUID = -6542355149686325549L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.获得要下载的资源
		String path = this.getServletContext()
				.getRealPath("/download/人在鸟途.avi");
		File file = new File(path);
		FileInputStream in = new FileInputStream(file);

		// 2.读取资源数据，并打给客户机
		OutputStream out = response.getOutputStream();
		byte buffer[] = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}

		// 3.通知客户机以下载方式打开服务器发送的数据 ,如果文件名是中文，记得要使用URLEncoder进行url编码
		response.setHeader("content-disposition", "attachment;filename="
				+ URLEncoder.encode(file.getName(), "UTF-8"));

		// 4.关流
		in.close();
		// out.close();
		// 由于out是通过服务器的response得到的，服务器在销毁response时，会自动关流，所在开发人员无须管关流的事

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
