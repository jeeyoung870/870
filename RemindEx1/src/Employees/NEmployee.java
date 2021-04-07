package Employees;

public class NEmployee extends Employee {	//NormalEmployee
	private int salary = 300;
	
	public NEmployee(String n, String ph, String ad, int sal) {
		super(n, ph, ad);
		this.salary = sal;
		// TODO Auto-generated constructor stub
	}

	
	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public void displayEmployee () {
		System.out.printf("일반사원 %s - %s - %s - 급여 : %d\n", getName(), getPhone(), getAddress(), getSalary());
	}
}
