package cn.conon.jee.sample.jsp.tag.simple;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//修改标签体
public class SimpleTagDemo4 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();

		StringWriter sw = new StringWriter();
		jf.invoke(sw);

		String content = sw.getBuffer().toString();
		String result = content.toUpperCase();
		this.getJspContext().getOut().write(result);
	}

}
