package Employees;

public class Employee {
	private String name = "김일";
	private String phone = "000-0000-0000";
	private String address = "서울시";
	private int salary = 300;
	
	public Employee (String n, String ph, String ad) {
		name = n;
		phone = ph;
		address = ad;
	}
	
	public void displayEmployee () {
		System.out.printf("사원 %s - %s - %s\n", getName(), getPhone(), getAddress());
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
}
