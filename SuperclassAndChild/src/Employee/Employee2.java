package Employee;

public class Employee2 extends Employee1 {	//Employee1을 부모 클래스로 두는 자식클래스
	private double salary;		//자식클래스에서 새로 추가된 메소드.
	
	public Employee2 (String n, String ad, String tn, Date jd, double sal) {
		super(n, ad, tn, jd);	//부모(super) 클래스의 생성자()안의 변수이름을 가져오면 사용가능
		this.salary = sal;		//필드에 있는 이름말고 같은 생성자에서 만든 이름.
	}
	
	public double payCheck () {
		return salary;		//자식클래스에만 있는 메소드. Employee2로 값을 입력했을 때에만 사용가능함.
	}
	
	public void displayEmployee2 () {
		System.out.printf("이름 : %s / 주소 : %s / 전화번호 : %s / 입사일 : %s / 급여 : %f\n",
							super.getName(), getAddress(), getTelno(), getJoinDate(), salary);
	}	//부모클래스의 필드가 public이면 필드에서 만든 이름 그대로 사용가능하지만(ex)name) 														
}		//private라면 부모클래스에서 public으로 만든 메소드를 이용해야 한다.
		//super.를 붙이면 부모클래스의 정확한 메소드를 소환가능.이름이 다르면 굳이 안붙여도됨
		//이름이 같은 메소드의 경우 가장 자식클래스의 메소드가 호출이 된다.