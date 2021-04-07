package AMain;
//멤버 클래스에서 제한
public class A3 {
	public int field1;
	public void method1() {
		System.out.println("A3의 method1 실행 - instance field1: " + field1);
	}
	
	static int field2;
	static void method2() {
		System.out.println("A3의 method2 실행 - static field2: " + field2);
	}
	
	public class B {
		void method() {
			System.out.println("<멤버 인스턴스 클래스 B의 메소드>");
			field1 = 10;
			method1();
			
			field2 = 20;
			method2();		//인스턴스 멤버클레스에서는 모든 클래스와 메소드에 접근가능
		}
	}
	
	static class C {
		void method() {
			System.out.println("<멤버 정적 클래스 C의 메소드>");
			//field1 = 30;
			field2 = 40;
			//method1();	//정적 클래스에서는 인스턴스 필드, 메소드 사용불가
			method2();
		}
	}
}
