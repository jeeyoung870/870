package Muliply;

public class Multiply {
	private int result;
	private double result2;
	private double result3 = 1;
	
	public Multiply () {
	}
	
	public void mul(int x, int y) {
		result = x*y;
		System.out.println(result);
	}
	public void mul (double x, double y) {
		result2 = x*y;
		System.out.println(result2);
	}
	public void mul (double ...v) {		//몇 개인지 모르는 숫자들의 총 곱.
		for (double e : v) {		//가변인수 v는 배열로 저장된다.
			result3 *= e;
		}
		System.out.println(result3);
	}
	

}
