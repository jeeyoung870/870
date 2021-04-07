
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; ++i) {
			if(i % 2 ==0)	//i가 짝수일때
				continue;	//if문에 부합하면 아랫줄 수행하지 않고 for로 돌아감.
			System.out.printf("%d번째 당신을 사랑합니다. \n", i);
		}

	}

}
