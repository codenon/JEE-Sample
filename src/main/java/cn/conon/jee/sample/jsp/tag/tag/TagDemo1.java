package cn.conon.jee.sample.jsp.tag.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

//控制标签体是否执行
public class TagDemo1 extends TagSupport {

	@Override
	public int doStartTag() throws JspException {

		// 在标签处理器内要想控制标签体是否执行，只需要根据条件返回SKIP_BODY或EVAL_BODY_INCLUDE
		return Tag.SKIP_BODY;
	}

}
