package Employee;
public class Employee1 {
	private String name;
	private String address;
	private String telno;
	private Date joinDate;
	
	public Employee1 (String n, String ad, String tn, Date jd) {
		this.name = n;
		this.address = ad;
		this.telno = tn;
		this.joinDate = jd;
	}
	
	public double payCheck () {
		return 0.0;
	}
	
	//public int pc = payCheck(); ->오류(부모클래스에서 자식클래스의 메소드를 쓸 수 없다.)
	
	public String getName() {
		return name;
	}



	public String getAddress() {
		return address;
	}



	public String getTelno() {
		return telno;
	}



	public Date getJoinDate() {
		return joinDate;
	}



	public void showName () {System.out.println("이름 : " + name);}
	
	public void displayEmployee1() {
		System.out.printf("이름 : %s / 주소 : %s / 전화번호 : %s / 입사일 : %s\n",
							getName(), getAddress(), getTelno(), getJoinDate());
	}
}
