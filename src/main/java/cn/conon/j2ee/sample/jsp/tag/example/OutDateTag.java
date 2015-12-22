package cn.conon.j2ee.sample.jsp.tag.example;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OutDateTag extends SimpleTagSupport {

	private Date date;

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println(date);
	}

}
