package cn.conon.jee.sample.jsp.i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

public class Demo5 {

	/**
	 * 消息文本国际化
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String pattern = "On {0}, a hurricance destroyed {1} houses and caused {2} of damage.";

		MessageFormat format = new MessageFormat(pattern, Locale.US);
		// 准备替换占位符的数据
		Object params[] = new Object[]{new Date(), 99, 100000};

		// 用数据格式化消息文本输出
		String result = format.format(params);
		System.out.println(result);

	}

}
