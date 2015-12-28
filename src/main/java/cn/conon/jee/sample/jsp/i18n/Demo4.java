package cn.conon.jee.sample.jsp.i18n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Demo4 {

	/**
	 * 数值国际化
	 * 
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		double price = 34.5;

		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
		String result = nf.format(price);
		System.out.println(result);

		String p = "NT$34.50";
		nf = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
		Number n = nf.parse(p);
		System.out.println(n.doubleValue());

		double num = 0.5;
		nf = NumberFormat.getPercentInstance(Locale.CANADA); // 0.5 50%
		result = nf.format(num);
		System.out.println(result);
	}

}
