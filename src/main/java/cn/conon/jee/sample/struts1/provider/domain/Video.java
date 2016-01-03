package cn.conon.jee.sample.struts1.provider.domain;

public class Video {
	private Integer id;
	private String title;
	private Integer timelength;
	public Video() {
	}

	public Video(Integer id, String title, Integer timelength) {
		this.id = id;
		this.title = title;
		this.timelength = timelength;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

}
