
public class ForSumFrom1To100Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;		//sum : 합계 변수
		
		int i = 0;		//for문 전에 카운터 변수를 선언하면 for문 밖에서도 사용가능
		for (i = 1; i <= 100; ++i) {
			sum += i;
		}
		
		System.out.println("1~" + (i-1) + "의 합 : " + sum);

	}

}
