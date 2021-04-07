
public class Ex_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] temp = { -4, -1, 4, 11, 17, 21, 24, 25, 20, 13, 6, -1 };
		int sum = 0;
		
		for (int i = 0; i < temp.length; ++i) {
			System.out.print(temp[i] + "도  ");
		}
		System.out.println();
		for (int e : temp) {
			sum += e;
		}System.out.println("서울의 평균 기온 : " + sum/12 + "도");
	}

}
