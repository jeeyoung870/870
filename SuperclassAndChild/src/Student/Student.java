package Student;

public class Student extends People {
	public int studentNo;
	
	public Student (String n, String ssn, int stuN) {
		super(n, ssn);		//부모 생성자 호출
		this.studentNo = stuN;
	}
	

}
