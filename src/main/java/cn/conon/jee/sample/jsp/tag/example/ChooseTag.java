package cn.conon.jee.sample.jsp.tag.example;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {

	private boolean isdo; // 用于记住子标签是否执行过标签体,如果为true,则代表执行过标签，false反之

	public boolean isIsdo() {
		return isdo;
	}

	public void setIsdo(boolean isdo) {
		this.isdo = isdo;
	}

	@Override
	public void doTag() throws JspException, IOException {
		this.getJspBody().invoke(null);
	}

}
