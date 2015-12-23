package cn.conon.jee.sample.jsp.tag.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//对map\collection\array都可以迭代
public class ForEachTag2 extends SimpleTagSupport {

	private String var;
	private Object items; // new String[]{}
	private Collection collection; // 不管用户传递进来的是什么集合，都跟它把数据整到collection中

	public void setVar(String var) {
		this.var = var;
	}
	public void setItems(Object items) {
		this.items = items;

		// int[]
		if (items instanceof Collection) {
			this.collection = (Collection) items;
		}
		if (items instanceof Map) {
			Map map = (Map) items;
			this.collection = map.entrySet(); // set
		}
		if (items instanceof Object[]) {
			Object objs[] = (Object[]) items;
			this.collection = Arrays.asList(objs);
		}
		if (items instanceof int[]) {
			int i[] = (int[]) items;
			this.collection = new ArrayList();
			for (int num : i) {
				this.collection.add(num);
			}
		}

	}
	@Override
	public void doTag() throws JspException, IOException {

		Iterator it = collection.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			this.getJspContext().setAttribute(var, obj);
			this.getJspBody().invoke(null);
		}
	}

}
