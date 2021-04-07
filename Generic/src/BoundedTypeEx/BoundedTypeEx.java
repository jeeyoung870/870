package BoundedTypeEx;

public class BoundedTypeEx {

	public static void main(String[] args) {
		//String str = Util.compare("A", "fds");	오류
		//<T extends Number>로 매개값 타입을 숫자로 제한했기 떄문에 String은 사용불가
		
		int result1 = Util.compare(87, 42.535);
		System.out.println(result1);
		
		if (result1 < 0) {
			System.out.println("값1이 값2보다 작다.");
		}else if (result1 == 0) {
			System.out.println("값1과 값2는 같다.");
		}else System.out.println("값1이 값2보다 크다.");
		
		int result2 = Util.compare(2.434253, 43);
		if (result2 < 0) {
			System.out.println("값1이 값2보다 작다.");
		}else if (result1 == 0) {
			System.out.println("값1과 값2는 같다.");
		}else System.out.println("값1이 값2보다 크다.");
		

	}

}
