package AMain;
//바깥 필드와 메소드에서 사용 제한되는 멤버클래스 객체
public class A2 {
	//인스턴스 멤버 클래스
	class B{}
	//정적 멤버클래스
	static class C{}
	
	//인스턴스 필드
	public B field1 = new B();	//인스턴스 멤버클래스로 필드 생성 가능
	public C field2 = new C();	//정적 멤버클래스로 필드 생성 가능
	
	//정적 필드 초기화
	//static B field3 = new B();	//인스턴스 클래스 객체는 정적 필드로 초기화 불가능
	static C field4 = new C();	 //정적클래스 객체는 정적 필드로 초기화가능
	
	//인스턴스 메소드 
	public void method1() {
		B var1 = new B();
		C var2 = new C();	//instance, static 클래스 객체 둘다 메소드에서 생성가능
	}
	//정적 메소드
	public static void method2() {
		//B var1 = new B();		정적 메소드에서 인스턴스 클래스의 객체 생성 불가능
		C var2 = new C();		//정적클래스 객체만 생성가능
	} 
}
