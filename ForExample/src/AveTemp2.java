
public class AveTemp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int aveTemp [] = {-4, -1, 4, 11, 17, 21, 24, 25, 20, 13, 6, -1};
		
		for (int temp : aveTemp) {
			System.out.println(temp);
		}
		for (int i = 0; i < aveTemp.length; ++i) {
			System.out.println((i+1) + "월의 기온 : " + aveTemp[i] + "도");
		}
		int sum = 0;
		for (int s = 0; s < aveTemp.length; ++s) {
			sum += aveTemp[s];
		}
		System.out.println("연평균기온 : " + sum/aveTemp.length + "도");
	}

}
