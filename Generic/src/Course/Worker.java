package Course;

public class Worker extends Person {
	private int days;

	public Worker(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		days = 0;
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays(int days) {
		this.days = days;
	}
}
