package cn.conon.jee.sample.jsp.tag.simple;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//迭代标签体
public class SimpleTagDemo3 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		JspFragment jf = this.getJspBody();
		for (int i = 0; i < 5; i++) {
			jf.invoke(null);
		}

	}

}
