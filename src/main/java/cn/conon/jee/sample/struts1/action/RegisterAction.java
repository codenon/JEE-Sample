package cn.conon.jee.sample.struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.conon.jee.sample.struts1.formbean.UserForm;

public class RegisterAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/* UserForm userForm = (UserForm) form; */

		System.out.println(mapping.getParameter());

		UserForm userForm = (UserForm) request.getAttribute("useForm");

		String username = userForm.getUsername();
		String password = userForm.getPassword();
		String password2 = userForm.getPassword2();
		String email = userForm.getEmail();

		try {
			System.out.println("注册用户到数据库" + username);
			request.setAttribute("message", "注册成功！！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "注册失败！！");
		}

		// 基于配置文件进行转发
		ActionForward forward = mapping.findForward("message");

		return forward;
	}

}
