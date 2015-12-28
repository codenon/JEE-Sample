package cn.conon.jee.sample.jsp.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ResourceBundle bundle = ResourceBundle.getBundle("cn.itcast.resource.myresource", Locale.ENGLISH);
		String username = bundle.getString("username");
		String password = bundle.getString("password");

		System.out.println(username);
		System.out.println(password);

	}

}
