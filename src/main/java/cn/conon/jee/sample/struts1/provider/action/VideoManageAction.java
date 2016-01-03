package cn.conon.jee.sample.struts1.provider.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.conon.jee.sample.struts1.provider.formbean.VideoForm;
import cn.conon.jee.sample.struts1.provider.utils.StreamTool;

public class VideoManageAction extends DispatchAction {

	public ActionForward getXML(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		InputStream inStream = request.getInputStream();
		byte[] data = StreamTool.readStream(inStream);
		String xml = new String(data, "UTF-8");
		System.out.println(xml);
		return mapping.findForward("result");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VideoForm formbean = (VideoForm) form;
		if ("GET".equals(request.getMethod())) {
			String title = new String(request.getParameter("title").getBytes("ISO8859-1"), "UTF-8");
			System.out.println("视频名称:" + title);
		} else {
			System.out.println("视频名称:" + formbean.getTitle());
		}
		System.out.println("时长:" + formbean.getTimelength());

		if (formbean.getVideofile() != null && formbean.getVideofile().getFileSize() > 0) {
			// /video
			String realpath = request.getSession().getServletContext().getRealPath("/video");
			System.out.println(realpath);
			File dir = new File(realpath);
			if (!dir.exists())
				dir.mkdirs();
			File saveFile = new File(dir, formbean.getVideofile().getFileName());
			FileOutputStream outStream = new FileOutputStream(saveFile);
			outStream.write(formbean.getVideofile().getFileData());
			outStream.close();
		}
		return mapping.findForward("result");
	}
}
