package cn.conon.jee.sample.struts1.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

public class UserForm extends ActionForm {

	private String username;
	private String password;
	private String password2;
	private String email;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// actionServlet
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		if (username == null || username.trim().equals("")) {
			// 1.直接在程序中封装错语消息
			// errors.add("username", new ActionMessage("用户名不能为空",false));
			// //用户名不能为空

			// 2.从资源文件中以key为关键字，获取错语消息封装
			// errors.add("username", new
			// ActionMessage("errors.username.required"));

			// 3.以key为关键字从资源文件中获取错误消息时，如果有占位符，如何替换
			// errors.add("username", new
			// ActionMessage("errors.required","用户名")); //"用户名"用于替换占位符

			// 4.占位符的数据也从资源文件中获取
			/*
			 * ResourceBundle bundle =
			 * ResourceBundle.getBundle("cn.itcast.resource.MyResource");
			 * errors.add("username", new
			 * ActionMessage("errors.required",bundle.
			 * getString("prompt.username")));
			 */

			MessageResources message = MessageResources.getMessageResources("cn.itcast.resource.MyResource");
			errors.add("username", new ActionMessage("errors.required", message.getMessage("prompt.username")));
		}
		return errors;
	}

}
