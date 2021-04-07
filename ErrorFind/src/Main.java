
public class Main {
	public static double divideByZero (int x, int y) {
		return x/y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 50;
		int y = 0;
		double r;
		
		try {
			r = divideByZero (x, y);
			System.out.printf("결과 : %f\n", r);		//0으로 나눌 경우 실행되지 않음.
		}
		catch (ArithmeticException e) {		//산술 에러일 경우인 변수 e
			System.out.println("0으로 나누기 예외가 발생하였습니다.");	//안내문 출력
		}
		finally {
			System.out.println("처리가 완료되었습니다.");	//에러없을 경우 이것만 출력
		}

	}

}
