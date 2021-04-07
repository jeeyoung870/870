package Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee2 emp1 = new Employee2("김일", "서울시", "111-1111", new Date(2010, 1, 1),
										100);
		emp1.showName();		//자식클래스로 값입력해도 수퍼클래스의 메소드 사용가능
		emp1.displayEmployee2();	
		System.out.println(emp1.payCheck());
		
		Employee1 emp2 = new Employee1("김이", "서울시", "222-2222", new Date(2020, 1, 1));
		Employee1 emp3 = new Employee1("김삼", "서울시", "333-3333", new Date(2020, 1, 1));
		Employee1 emp4 = new Employee1("김사", "서울시", "444-4444", new Date(2020, 1, 1));
		Employee1 emp5 = new Employee1("김오", "서울시", "555-5555", new Date(2020, 1, 1));
		Employee1 emp6 = new Employee1("김육", "서울시", "666-6666", new Date(2020, 1, 1));
		Employee1 emp7 = new Employee1("김칠", "서울시", "777-7777", new Date(2020, 1, 1));
		Employee1 emp8 = new Employee1("김팔", "서울시", "888-8888", new Date(2020, 1, 1));
		Employee1 emp9 = new Employee1("김구", "서울시", "999-9999", new Date(2020, 1, 1));
		Employee1 emp10= new Employee1("김십", "서울시", "101-0101", new Date(2020, 1, 1));
		Employee1 emp11= new Employee1("김십일", "서울시", "111-1111", new Date(2020, 1, 1));
		Employee1 emp12= new Employee1("김십이", "서울시", "121-2121", new Date(2020, 1, 1));
	
		
		Department dept = new Department("개발 1부");
		dept.addEmployee(emp2);
		dept.addEmployee(emp3);
		dept.addEmployee(emp4);
		dept.addEmployee(emp5);
		dept.addEmployee(emp6);
		dept.addEmployee(emp7);
		dept.addEmployee(emp8);
		dept.addEmployee(emp9);
		dept.addEmployee(emp10);
		dept.addEmployee(emp11);
		dept.addEmployee(emp12);	//Department클래스에서 headCount 10명까지만 받기로 했으므로
									//11번째로 추가한 사원은 출력이 안됨
		dept.display();
		
		TemporaryEmployee t1 = new TemporaryEmployee("박일", "서울시", "131-1313", new Date(2020, 11, 12), 10000);
		t1.setHours(7);
		t1.payCheck();
		System.out.println(t1.payCheck ());
		
		
		Employee2 emp13 = new Employee2("김일", "서울시", "111-1111", new Date(2010, 1, 1),
				100);
		if (emp1 == emp13)
			System.out.println("같다.");
		else
			System.out.println("다르다.");	//문자열 내용이 같아도 참조값이 다르므로 "다르다." 출력됨.
		
		if (emp1.equals(emp13))
			System.out.println("같다.");
		else
			System.out.println("다르다.");	//문자열 내용이 같아도 참조값이 다르므로 "다르다." 출력됨.
		
		
		Date date = new Date(2020, 11, 12);
		System.out.println(date);
		Employee2 emp14 = new Employee2("김일", "서울시", "111-1111", date, 100);
		emp14.displayEmployee2();
		
		Department d1 = new Department ("개발 1부");
		if(dept.equals(d1))		//Department클래스에서 object메소드 equals 설정으로 string내용이 같으면 같다고 판단하게 됨.
			System.out.println("같다.");
		else
			System.out.println("다르다.");
		if(dept == d1)
			System.out.println("같다.");
		else
			System.out.println("다르다.");
		
		System.out.println(d1);
			
		
		
	}

}








