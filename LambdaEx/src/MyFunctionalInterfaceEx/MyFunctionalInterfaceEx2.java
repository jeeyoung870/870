package MyFunctionalInterfaceEx;

public class MyFunctionalInterfaceEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFunc2 mf;
		
		mf = (x) -> {
			int result = x*5;
			System.out.println(result);
		};
		mf.method(2); 	//x값에 2 대입	결과값 : 10
		
		mf = (x) -> {
			System.out.println(x*5);
		};
		mf.method(2);
		
		mf = x -> System.out.println(x*5);	//매개변수가 하나, 명령문 하나일 경우 (),{}생략가능
		mf.method(2);
		
		

	}

}
