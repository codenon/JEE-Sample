package cn.conon.jee.sample.jsp.tag.simple;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//控制标签体是否执行
public class SimpleTagDemo2 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		// 拿到标签体
		JspFragment jf = this.getJspBody();
		// 执行标签体
		jf.invoke(null); // null代表写给浏览器

	}

}
