package cn.conon.j2ee.sample.jsp.tag.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
//用自定义标签控制jsp页面内容重复执行
public class TagDemo3 extends TagSupport {
	private int i = 0;
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return Tag.EVAL_BODY_INCLUDE;
	}

	// 只要doAfterBody方法返回EVAL_BODY_AGAIN，服务器就会再执行一次标签体
	@Override
	public int doAfterBody() throws JspException {
		i++;
		if (i < 5) {
			return IterationTag.EVAL_BODY_AGAIN;
		} else {
			return IterationTag.SKIP_BODY;
		}
	}

}
