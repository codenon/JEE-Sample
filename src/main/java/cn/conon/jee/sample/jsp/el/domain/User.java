package cn.conon.jee.sample.jsp.el.domain;

public class User {
	private String name = "xxx";
	private String gender;
	private String[] likes = new String[]{"basketball", "dance"};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getLikes() {
		return likes;
	}

	public void setLikes(String[] likes) {
		this.likes = likes;
	}

}
