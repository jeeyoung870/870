
public class BreakExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {		//true = 무한반복문
			int num = (int)(Math.random() * 6) + 1;
			System.out.println(num);
			
			if (num == 6) {
				break;		//break;로 while문 종료
			}
			
		} 
		System.out.println("프로그램 종료.");		//while문이 끝나면 출력됨.
	}

}
