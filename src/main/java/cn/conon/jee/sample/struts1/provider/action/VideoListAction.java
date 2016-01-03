package cn.conon.jee.sample.struts1.provider.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.conon.jee.sample.struts1.provider.domain.Video;
import cn.conon.jee.sample.struts1.provider.formbean.VideoForm;
import cn.conon.jee.sample.struts1.provider.service.VideoService;
import cn.conon.jee.sample.struts1.provider.service.impl.VideoServiceBean;

public class VideoListAction extends Action {
	private VideoService service = new VideoServiceBean();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VideoForm formbean = (VideoForm) form;
		List<Video> videos = service.getLastVideos();
		if ("json".equals(formbean.getFormat())) {
			// [{id:90,title:"xxxx",timelength:67},{id:90,title:"xxxx",timelength:67}]
			StringBuilder sb = new StringBuilder();
			sb.append('[');
			for (Video video : videos) {
				sb.append('{');
				sb.append("\"id\":").append(video.getId()).append(',');
				sb.append("\"title\":\"").append(video.getTitle()).append("\",");
				sb.append("\"timelength\":").append(video.getTimelength());
				sb.append('}');
				sb.append(',');
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append(']');
			request.setAttribute("json", sb.toString());
			return mapping.findForward("json");
		} else {
			request.setAttribute("videos", videos);
			return mapping.findForward("xml");
		}
	}
}
