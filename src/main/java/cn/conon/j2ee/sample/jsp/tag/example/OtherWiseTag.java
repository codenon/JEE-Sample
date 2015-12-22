package cn.conon.j2ee.sample.jsp.tag.example;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherWiseTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		ChooseTag parent = (ChooseTag) this.getParent();
		if (parent.isIsdo() == false) {
			this.getJspBody().invoke(null);
			parent.setIsdo(true);
		}

	}

}
