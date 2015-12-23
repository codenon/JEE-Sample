package cn.conon.jee.sample.jsp.tag.example;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfTag extends SimpleTagSupport {
	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {

		// 根据test的值决定是否执行标签体
		if (test) {
			this.getJspBody().invoke(null);
		}

	}

}
