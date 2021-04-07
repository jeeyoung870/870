package Course;

public class Student extends Person {
	private int rate;

	public Student(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		rate = 0;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	

}
