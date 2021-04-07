package MyFunctionalInterfaceEx;
public class MyFunctionalInterfaceEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFunc mf; 	//인터페이스 객체선언
		
		mf = () -> {	//매개변수가 없기 때문에 ()안이 비었음.
			String str = "method call1";
			System.out.println(str);
		};
		
		mf.method(); 	//인터페이스 MyFunc의 메소드 호출 - 람다식{}안의 명령문 실행
		
		mf = () -> {
			System.out.println("method call2");
		};
		mf.method();
		
		mf = () -> System.out.println("method call3");	//실행문이 하나라면 {} 생략가능 
		mf.method();
		
		//같은 인터페이스의 같은 메소드를 내용물(실행문)만 바꿔서 사용가능함.
	}

}
