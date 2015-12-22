package cn.conon.j2ee.sample.jsp.tag.example;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {

	private String var;
	private Collection items;
	public void setVar(String var) {
		this.var = var;
	}
	public void setItems(Collection items) {
		this.items = items;
	}
	@Override
	public void doTag() throws JspException, IOException {

		Iterator it = items.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			PageContext context = (PageContext) this.getJspContext();
			context.setAttribute(var, obj);
			this.getJspBody().invoke(null); // ${str}--pageContext
		}

	}

}
