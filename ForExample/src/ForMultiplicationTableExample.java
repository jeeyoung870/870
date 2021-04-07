
public class ForMultiplicationTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int m = 2; m <= 9; ++m) {
			System.out.println("*** " + m + "단 ***");
			for (int n = 1; n <= 9; ++n) {
				System.out.println(m +" x " + n + " = " + (m*n));
			}	//아래 for문이 다 실행되고 나면 위의 for문으로 돌아간다.
		}

	}

}
