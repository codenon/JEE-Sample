package cn.conon.jee.sample.struts2.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import cn.conon.jee.sample.struts2.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private User user;
	private HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String execute() throws Exception {
		// request.setAttribute("message", "您好，通过xxxAware接口实现了访问Servlet API");
		ServletActionContext.getRequest().setAttribute("message", "您好，通过ServletActionContext类直接访问Servlet API");

		ActionContext ac = ActionContext.getContext();
		if (user.getUsername().equals("admin") && user.getPassword().equals("123")) {
			// 通过ActionContext对象访问Web应用的Session
			// context.put("name", "Mike");
			// context.getSession().put("name","Mike");
			// context.getApplication().put("name", "Mike");

			ac.put("success", "登录成功");
			ac.getSession().put("username", user.getUsername());
			ac.getSession().put("password", user.getPassword());
			System.out.println(user.getUsername() + "----" + user.getPassword());
			return SUCCESS;
		} else {
			ac.put("error", "用户名或密码错误");
			return ERROR;
		}
	}

	// setter、getter赋值和取值
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
