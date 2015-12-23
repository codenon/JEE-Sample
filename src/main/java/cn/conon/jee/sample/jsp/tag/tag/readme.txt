1、写一个类（标签处理器类），实现tag接口，并覆盖其中的doStartTag方法

public class ViewIPTag implements Tag {

	private PageContext pageContext;
	
	public void setPageContext(PageContext arg0) {
		this.pageContext = arg0;
	}
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
		String ip = request.getRemoteAddr();
		
		JspWriter out = this.pageContext.getOut();
		try {
			out.write(ip);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	public int doEndTag() throws JspException {
		return 0;
	}
	
	public Tag getParent() {
		return null;
	}

	public void release() {
	}

	

	public void setParent(Tag arg0) {
	}
}

2、在WEB-INF目录中新建一个tld文件（标签库描述文件）中，然后抄C:\apache-tomcat-6.0.20\webapps\examples\WEB-INF\jsp2这个文件夹下面的一个tld模块，在tld文件中，对标签处理器类进行描述
<?xml version="1.0" encoding="UTF-8" ?>

<taglib xmlns="http://java.sun.com/xml/ns/jee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/jee http://java.sun.com/xml/ns/jee/web-jsptaglibrary_2_0.xsd"
    version="2.0">
    
    <description>A tag library exercising SimpleTag handlers.</description>
    <tlib-version>1.0</tlib-version>
    <short-name>SimpleTagLibrary</short-name>
    <uri>/itcast</uri>
    
    <tag>
        <name>viewIP</name>
		<tag-class>cn.itcast.web.tag.ViewIPTag</tag-class>
		<body-content>empty</body-content>
    </tag>
</taglib>


3、在jsp页面中导入并使用自定义标签 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="/itcast" prefix="itcast" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示IP</title>
  </head>
  
  <body>
    您的IP是：<itcast:viewIP/>
    
  </body>
</html>


传统自定义标签技术概述

1、移除jsp页面java代码，要实现这个功能只需要Tag接口，并把需要移除的代码放到tag接口的doStartTag方法内。

2、控制标签体是否执行（即控制jsp页面某段内容是否执行），要实现这个功能，只需要实现tag接口的doStartTag方法，该方法如果返回EVAL_BODY_INCLUDE则执行标签体，如果返回SKIP_BODY，则不会执行标签体。

3、控制jsp页面是否执行，要实现这个功能，只需要实现Tag接口的doEndTag方法，该方法如果返回EVAL_PAGE，则标签余下的jsp页面会执行，哪果返回SKIP_page则标签余下的jsp页面不会执行。

4、控制jsp页面某一段内容重复执行（标签体重复执行），要实现这个功能，需要实现IterationTag接口，并覆盖doStartTag方法和doAfterBody方法，让doStartTag方法返回EVAL_BODY_INCLUDE(让标签体先执行)，并通过控制doAfterBody方法的返回值（EVAL_BODY_AGAIN）,来实现重复执行标签体。

5、修改标签体（修改jsp页面内容），要实现这个功能，需要实现BodyTag接口，并覆盖doStartTag方法和doEndTag方法，覆盖doStartTag方法的目的是为了返回EVAL_BODY_BUFFERED，使jsp执行标签体，并把标签体写到一个容器中，然后覆盖doEndTag方法的目的，是为了得到写满标签体的容器，以便于修改后输出。


简单标签技术概述

1、移除jsp页面java代码，要实现这个功能只需要SimpleTag接口，并把需要移除的代码放到接口的doTag方法内。

2、控制标签体是否执行（即控制jsp页面某段内容是否执行,要实现这个功能只需要SimpleTag接口，并覆盖doTag方法，在dotag方法体内，控制代表标签体的jspFragment是否执行，就可以实现控制标签体是否执行

3、控制jsp页面某一段内容重复执行（标签体重复执行），要实现这个功能，只需要SimpleTag接口，并覆盖doTag方法，在dotag方法体内,循环执行代表标签体的jspFragment对象即可。

4、修改标签体（修改jsp页面内容），要实现这个功能，只需要SimpleTag接口，并覆盖doTag方法，在dotag方法体内，得到代表标签体的jspFragment对象，让这个对象执行时，其执行结果写到一个容器中，然后开发人员可以从容器中取数据修改后再输出给客户机。

5、控制jsp页面是否执行，要实现这个功能，只需要SimpleTag接口，并覆盖doTag方法，在dotag方法内抛SKIPPageException异常，则容器就不会执行标签后面的余下jsp。



如何让标签拥有属性

1、在标签处理器类中定义相应的set方法接收属性
	public class SimpleTagDemo6 extends SimpleTagSupport {

	private int count;
	
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public void doTag() throws JspException, IOException {
		
		for(int i=0;i<count;i++){
			this.getJspBody().invoke(null);
		}
		
	}
	}

2、在tld文件中描述属性
   <tag>
        	<name>SimpleTagDemo6</name>
		<tag-class>cn.itcast.web.simpleTag.SimpleTagDemo6</tag-class>
		<body-content>scriptless</body-content>
		
		<attribute>
			<name>count</name>
			<required>true</required>
			<rtexprvalue>true</rtexprvalue>  <!-- 指定属性值是否可以是一个脚本或EL表达式 -->
		</attribute>
    </tag>

3、在页面中就可以使用标签属性
	<itcast:SimpleTagDemo6 count="7">
  		xxxx
  	</itcast:SimpleTagDemo6>
	