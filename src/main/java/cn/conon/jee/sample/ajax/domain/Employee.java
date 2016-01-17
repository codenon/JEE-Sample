package cn.conon.jee.sample.ajax.domain;

public class Employee {

	private int employeeId;
	private String employeeName;
	private String email;
	private float salary;

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [email=" + email + ", employeeId=" + employeeId
				+ ", employeeName=" + employeeName + ", salary=" + salary + "]\n";
	}
}
