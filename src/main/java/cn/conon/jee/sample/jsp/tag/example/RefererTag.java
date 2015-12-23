package cn.conon.jee.sample.jsp.tag.example;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//防盗链标签
public class RefererTag extends SimpleTagSupport {

	private String site; // 防哪个网站的盗链
	private String page; // 对于盗链者跳到哪个页面
	public void setSite(String site) {
		this.site = site;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public void doTag() throws JspException, IOException {

		// 拿到来访问者的referer
		PageContext context = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		String referer = request.getHeader("referer"); // 来访者从哪个页面来的

		if (referer == null || !referer.startsWith(site)) {
			// 是盗链者就重定向
			HttpServletResponse response = (HttpServletResponse) context.getResponse();
			response.sendRedirect(page);
			throw new SkipPageException();
		}
	}
}
