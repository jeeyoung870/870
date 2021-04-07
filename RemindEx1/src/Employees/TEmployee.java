package Employees;

public class TEmployee extends Employee {	//TemporaryEmployee
	private int hour;	//근무시간
	private int timeMoney = 5;	//시간수당
	private int tSalary;
	
	public TEmployee(String n, String ph, String ad, int h) {
		super(n, ph, ad);
		setHour(h);
		// TODO Auto-generated constructor stub
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public int getTimeMoney() {
		return timeMoney;
	}
	
	public void timeMoney(int tm) {
		this.timeMoney = tm;
	}
	
	public int gettSalary() {
		tSalary = getTimeMoney()*getHour();
		return tSalary;
	}

	public void displayEmployee () {
		System.out.printf("임시사원 %s - %s - %s - 월급 : %d\n", getName(), getPhone(), getAddress(), gettSalary());
	}
	
}
