package cn.conon.jee.sample.jsp.i18n;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Demo3 {

	/**
	 * 用dateformat作反向解析时，一定要根据日期字符串的样式，设好相应的dateformat的格式
	 */
	public static void main(String[] args) throws ParseException {

		// 将字符串转成日期
		String date = "2010年7月25日"; // Date

		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
		Date d = df.parse(date);
		System.out.println(d);

		date = "10-7-25 下午03时09分42秒 CST";
		df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL, Locale.CHINA);
		d = df.parse(date);
		System.out.println(d);
	}

}
