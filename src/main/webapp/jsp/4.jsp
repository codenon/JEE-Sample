<%@page import="org.apache.commons.io.IOUtils"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%
	String path = application.getRealPath("/download/1.txt");
	File file = new File(path);

	response.setContentType("application/octet-stream");
	response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));

	FileInputStream in = new FileInputStream(file);
	byte buffer[] = new byte[1024];
	int len = 0;
	while ((len = in.read(buffer)) > 0) {
		response.getOutputStream().write(buffer, 0, len);
	}
	IOUtils.closeQuietly(in);
%>