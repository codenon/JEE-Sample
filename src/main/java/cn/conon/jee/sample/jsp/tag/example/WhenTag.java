package cn.conon.jee.sample.jsp.tag.example;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {

	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {

		ChooseTag parent = (ChooseTag) this.getParent();
		if (parent.isIsdo() == false && this.test == true) {
			this.getJspBody().invoke(null);
			// 执行过标签体了，要把父标签的isDo属性值为true
			parent.setIsdo(true);
		}

	}

}
