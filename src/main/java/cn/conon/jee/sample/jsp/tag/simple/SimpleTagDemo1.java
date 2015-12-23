package cn.conon.jee.sample.jsp.tag.simple;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//移除jsp页面输出ip代码
public class SimpleTagDemo1 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		PageContext context = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		String ip = request.getRemoteAddr();

		context.getOut().write(ip);

	}

}
