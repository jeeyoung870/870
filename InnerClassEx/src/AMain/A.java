package AMain;

//바깥 클래스
public class A {
	public A () {
		System.out.println("A 객체가 생성됨.");
	}
	//인스턴스 멤버 클래스
	public class B {
		public B () {
			System.out.println("B 객체가 생성됨.");
		}
		
		int field1;
		//static int field2;	인스턴스 클래스에서는 static으로 필드 못 만듬.
		void method1() {
			System.out.println("B의 method1 실행 - " + field1);
		}
		//static void method2() {}	역시 static 메소드 생성불가
	}
	//static멤버클래스
	public static class C {
		public C() {
			System.out.println("C 객체가 생성됨.");
		}
		int field1;
		static int field2;
		
		void method1() {System.out.println("C의 인스턴스 method1 실행 " 
		+"instance : "+ field1 + "  static : " + field2);}
		
		static void method2() {
			System.out.println("C의 정적 method1 실행 - " + field2);
		}	//static 메소드에서는 인스턴스 필드(field1) 사용불가
	}
	
	public void method() {		//A의 메소드
		//로컬 클래스
		//static class D()	오류. 로컬클래스는 정적클래스로 못 만듬
		class D {
			public D() {
				System.out.println("D 객체가 생성됨.");
			}
			int field1;
			//static int field2;
			void method1() {
				System.out.println("D의 인스턴스 method1 실행 - " + field1);
			}
			//static void method2() {}
		}
		
		D d = new D();	//메소드 내부에서 로컬클래스 D의 객체 생성
		d.field1 = 3;
		d.method1();
		
	}
	

}
