package cn.conon.jee.sample.jsp.bean;

public class Address {
	private String city;

	public Address() {
		super();
	}

	public Address(String city) {
		super();
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
