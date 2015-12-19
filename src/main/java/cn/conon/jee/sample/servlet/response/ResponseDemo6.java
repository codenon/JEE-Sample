package cn.conon.jee.sample.servlet.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//输出认证码图片
public class ResponseDemo6 extends HttpServlet {
	private static final long serialVersionUID = 3058558980500569977L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 6.禁止浏览器缓存
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		// 5.通知浏览器以图片格式打开数据
		response.setContentType("image/jpeg");

		// 1.在内存中创建一副图片
		BufferedImage image = new BufferedImage(150, 30,
				BufferedImage.TYPE_INT_RGB);

		// 2.得到图片
		Graphics g = image.getGraphics();
		// 设置背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 150, 30);

		// 3.向图片上写数据
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体", Font.BOLD, 20));
		g.drawString(makeNum(), 0, 30);

		// 4.把图片输出给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());

	}

	@SuppressWarnings("unused")
	private String makeNum() {

		int start = '\u6c4e';
		int end = '\u6c4e' + 1000;

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 7; i++) {
			Random r = new Random();
			int num = r.nextInt(1000);
			sb.append((char) (start + num));
		}

		return sb.toString();

		/*
		 * Random random = new Random(); String num = random.nextInt(9999999) +
		 * ""; //0-9999999 1234567 123456
		 * 
		 * StringBuffer sb = new StringBuffer(); for(int
		 * i=0;i<7-num.length();i++){ sb.append("0"); }
		 * 
		 * return num + sb.toString();
		 */

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
