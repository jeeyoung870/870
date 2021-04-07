
public class MultiArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
		int k = 15;
		int [][] arr = new int [n][k];	//객체생성 [행][줄]
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < k; ++j) {
				arr[i][j] = (int) (Math.random() * 10);
				//배열의 각 요소에 들어갈 값 : 0~9사이의 수 중 랜덤뽑기
			}
		}	//여기까지 하면 n*k개의 랜덤뽑기가 끝남.
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < k; ++j) {	//k개의 배열을 n개 반복
				System.out.print(arr[i][j] + "  ");
			}System.out.println();	//한 줄 출력이 끝나면 줄바꿈하기
		}

	}

}
