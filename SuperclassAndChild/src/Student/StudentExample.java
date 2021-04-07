package Student;

public class StudentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student("홍길동", "1212-1212", 1);
		
		System.out.println("name : " + student1.name);	//부모 필드 출력
		System.out.println("ssn : " + student1.ssnum);
		System.out.println("studentNo : " + student1.studentNo);

	}

}
