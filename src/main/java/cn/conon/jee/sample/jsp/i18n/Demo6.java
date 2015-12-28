package cn.conon.jee.sample.jsp.i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Demo6 {

	/**
	 * 消息文本国际化
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * String pattern =
		 * "At {0, time, short} on {0, date}, a destroyed {1} houses and caused {2, number, currency} of damage."
		 * ;
		 * 
		 * MessageFormat mf = new MessageFormat(pattern,Locale.CHINA);
		 * 
		 * String result = mf.format(new Object[]{new Date(),99,1000000});
		 * 
		 * System.out.println(result);
		 */

		// 从资源文件中提取消息，实现国际化
		ResourceBundle bundle = ResourceBundle.getBundle("cn.itcast.resource.myresource", Locale.ENGLISH);
		String message = bundle.getString("message");

		MessageFormat mf = new MessageFormat(message, Locale.ENGLISH);
		Object params[] = {new Date(), 99, 100000};
		String result = mf.format(params);
		System.out.println(result);

	}

}
