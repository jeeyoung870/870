package Employees;

public class SEmployee extends NEmployee {	//SalaryEmployee
	private double insentive = 0.05;
	private double bonus;

	public SEmployee(String n, String ph, String ad, int sal, double insen) {
		super(n, ph, ad, sal);
		setInsentive(insen);
		// TODO Auto-generated constructor stub
	}

	public double getInsentive() {
		return insentive;
	}

	public void setInsentive(double insentive) {
		this.insentive = insentive;
	}
	
	public double getBonus () {
		bonus = getSalary()*getInsentive();
		return bonus;
	}
	
	public void displayEmployee () {
		System.out.printf("영업사원 %s - %s - %s - 급여 : %d 추가수당 : %f\n", getName(), getPhone(), getAddress(), getSalary(), getBonus());
	}
	
}
