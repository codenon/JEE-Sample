package cn.conon.jee.sample.jsp.tag.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TagDemo4 extends BodyTagSupport {

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return BodyTag.EVAL_BODY_BUFFERED;
	}

	@Override
	public int doEndTag() throws JspException {

		BodyContent content = this.getBodyContent(); // 拿到标签体
		String text = content.getString();
		String result = text.toUpperCase();

		JspWriter out = this.pageContext.getOut();
		try {
			out.write(result);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return super.doEndTag();
	}

}
