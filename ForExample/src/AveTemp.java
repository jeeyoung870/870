
public class AveTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] aveTemp = {-4, -1, 4, 11, 17, 21, 24, 25, 20, 13, 6, -1};
		for (int element : aveTemp) {
			System.out.println(element);
		}
		for (int i = 0; i < aveTemp.length; ++i)
			System.out.println((i + 1) + "월 : " + aveTemp[i]);
		
		int sum = 0;
		for (int s = 0; s < aveTemp.length; ++s) {
			sum += aveTemp[s];
		}
		System.out.println("연평균기온 : " + sum/aveTemp.length + "도");

	}

}
