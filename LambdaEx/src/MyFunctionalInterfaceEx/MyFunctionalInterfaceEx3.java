package MyFunctionalInterfaceEx;

public class MyFunctionalInterfaceEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFunc3 mf;
		
		mf = (x, y) -> {
			int result = x + y;
			return result;			//int 메소드라서 result를 주지 않으면 에러가 난다.
		};
		System.out.println(mf.method(2, 5));
		
		mf = (x, y) -> {
			return x + y;
		};
		System.out.println(mf.method(2, 5));
		
		mf = (x, y) -> x + y;				//명령문에 return문 하나만 있을 경우 {}와 return 생략가능
		System.out.println(mf.method(2, 5));
		
		mf = (x, y) -> sum(x, y);			//{}과 return 생략가능
		System.out.println(mf.method(2, 5));

	}

	public static int sum(int x, int y) {
		return x+y;
	}
}
