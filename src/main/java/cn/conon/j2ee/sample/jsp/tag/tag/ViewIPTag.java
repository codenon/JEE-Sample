package cn.conon.j2ee.sample.jsp.tag.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class ViewIPTag implements Tag {

	private PageContext pageContext;

	public void setPageContext(PageContext arg0) {
		this.pageContext = arg0;
	}
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
		String ip = request.getRemoteAddr();

		JspWriter out = this.pageContext.getOut();
		try {
			out.write(ip);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	public int doEndTag() throws JspException {
		return 0;
	}

	public Tag getParent() {
		return null;
	}

	public void release() {
	}

	public void setParent(Tag arg0) {
	}

}
