package cn.conon.jee.sample.jsp.i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Demo2 {

	/**
	 * DateFormat说明
	 */
	public static void main(String[] args) {

		Date d = new Date();

		// 输出时间值的日期部分
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
		String result = df.format(d);
		System.out.println(result);

		// 输出时间值的时间部分
		df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.ITALY);
		result = df.format(d);
		System.out.println(result);

		// 即输出日期又输出时间
		df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL, Locale.CHINA);
		result = df.format(d);
		System.out.println(result);
	}

}
