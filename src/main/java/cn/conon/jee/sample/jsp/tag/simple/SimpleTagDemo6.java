package cn.conon.jee.sample.jsp.tag.simple;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo6 extends SimpleTagSupport {

	private int count;
	private String content;

	public void setContent(String content) {
		this.content = content;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public void doTag() throws JspException, IOException {

		for (int i = 0; i < count; i++) {
			// this.getJspBody().invoke(null);
			this.getJspContext().getOut().write(content);
		}

	}
}
