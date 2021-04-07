package Employee;

public class Department {
	private Employee1 [] employees;	//Employee1 형식의 값들을 가진 변수들의 나열
	private int headCount;
	String deptName;
	
	
	public Department (String name) {	//생성자
		employees = new Employee1[10];	//employees의 배열 개수 선언
		headCount = 0;
		deptName = name;
	}
	
	public void addEmployee(Employee1 emp) {
		if (headCount < 10) {	//0~9까지, 10명까지만 사원 입력받기
			employees [headCount++] = emp;
		}
	}
	
	public void display () {
		for (int i = 0; i < headCount; ++i) {
			employees[i].displayEmployee1();
			double salary = employees[i].payCheck();	//Employee1의 payCheck()
			System.out.printf("%s - %s, 급여액 : %f\n", deptName, employees[i].getName(), salary);
		}
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		Department d = (Department)o;
		return this.deptName == d.deptName;
	}

	@Override
	public String toString() {		//문자그대로 출력하게 해주는 오브젝트코드
		// TODO Auto-generated method stub
		return deptName;
	}
	
	
	
}









