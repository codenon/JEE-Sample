package cn.conon.j2ee.sample.jsp.tag.simple;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//控制标签后面的jsp页面不要执行
public class SimpleTagDemo5 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
	}

}
