package Employees;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp1 = new Employee ("김일", "1111-1111", "서울시");
		NEmployee emp2 = new NEmployee ("김이", "2222-2222", "대전시", 280);
		SEmployee emp3 = new SEmployee ("김삼", "3333-3333", "광주시", 300, 0.08);
		TEmployee emp4 = new TEmployee ("김삼", "3333-3333", "광주시", 40);
		
		emp1.displayEmployee();
		emp2.displayEmployee();
		emp3.displayEmployee();
		emp4.displayEmployee();

	}

}
