package cn.conon.jee.sample.struts1.provider.formbean;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class VideoForm extends ActionForm {
	private String format;

	private String title;
	private Integer timelength;

	private FormFile videofile;

	public FormFile getVideofile() {
		return videofile;
	}

	public void setVideofile(FormFile videofile) {
		this.videofile = videofile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getTimelength() {
		return timelength;
	}

	public void setTimelength(Integer timelength) {
		this.timelength = timelength;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
