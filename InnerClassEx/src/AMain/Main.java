package AMain;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A a = new A();
		
		A.B b = a.new B();	//인스턴스 멤버클래스 B의 객체 생성
		b.field1 = 4;
		b.method1();
		
		A.C c = new A.C();	//static클래스 객체는 A a = new A(); 없이 바로 객체생성 가능
		c.field1 = 3;
		c.field2 = 4;
		c.method1();
		c.method2();
		
		a.method(); 	//로컬 클래스 D생성+ D클래스의 메소드 실행
		System.out.println();
		
		Outter outter = new Outter();
		outter.method1(13);
		outter.method2(23);
		
		
		

	}

}
