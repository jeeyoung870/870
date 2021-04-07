
public class WhileSumFrom1To100Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		
		int i = 1;
		
		while (i <= 100) {
			sum += i;
			++i;
		}
		System.out.println(i);	//마지막에 ++i로 끝나서 101이다.
		System.out.println("1~" + (i - 1) + " 의 합 : " + sum);	//1~100의 합.

	}

}
