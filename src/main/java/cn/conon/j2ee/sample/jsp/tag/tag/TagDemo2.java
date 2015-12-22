package cn.conon.j2ee.sample.jsp.tag.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

//控制jsp页面是否执行
public class TagDemo2 extends TagSupport {

	@Override
	public int doEndTag() throws JspException {

		// 要想控制jsp页面内容是否输出给客户机，只需要控制doEndTag方法的返回值即可，
		// 如果该方法返回SKIP_PAGE，则标签后面的jsp都不会输出，如果返回EVAL_PAGE，则标签后面的jsp会输出给客户端
		return Tag.SKIP_PAGE;
	}

}