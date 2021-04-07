package Employee;

public class TemporaryEmployee extends Employee1 {
	
	private double unitPay;
	private int hours;
	
	public TemporaryEmployee (String n, String ad, String tn, Date jd, double up) {
		super(n, ad, tn, jd);
		this.unitPay = up;
		hours = 0;
	}
	

	public void setHours (int h) {
		this.hours = h;
	}
	public double payCheck () {
		System.out.println("TemporaryEmployee.payCheck()");
		return unitPay * hours;
	}

}
