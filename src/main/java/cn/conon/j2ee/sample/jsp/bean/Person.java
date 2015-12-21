package cn.conon.j2ee.sample.jsp.bean;

public class Person {

	private String name;
	private String password;
	private int age;
	private Address address = new Address("北京");;

	public String getName() {
		return name;
	}
	public void setName(String name) { // name
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}
