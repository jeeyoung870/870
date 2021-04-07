package MyFunctionalInterfaceEx;

@FunctionalInterface 	//함수적 인터페이스 어노테이션.
//인터페이스 위에 붙여주면 한 개 이상의 메소드를 만드는 것을 방지해준다.
//람다식에서 사용할 수 있는 함수적 인터페이스는 한 개의 메소드만을 가질 수 있다.
public interface MyFunc {	
	public void method();
	//public void meethod2();	//두 개 만들면 MyFunc에 오류남.
}
