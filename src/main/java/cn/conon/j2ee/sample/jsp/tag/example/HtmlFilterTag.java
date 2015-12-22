package cn.conon.j2ee.sample.jsp.tag.example;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//修改标签体（即对标签体转义后）输出
public class HtmlFilterTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		StringWriter sw = new StringWriter();

		this.getJspBody().invoke(sw);

		String content = sw.getBuffer().toString(); // content="<a href=''></a>"
		String result = filter(content);
		this.getJspContext().getOut().write(result);

	}

	public String filter(String message) {

		if (message == null)
			return (null);

		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuffer result = new StringBuffer(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
				case '<' :
					result.append("&lt;");
					break;
				case '>' :
					result.append("&gt;");
					break;
				case '&' :
					result.append("&amp;");
					break;
				case '"' :
					result.append("&quot;");
					break;
				default :
					result.append(content[i]);
			}
		}
		return (result.toString());

	}

}
