import java.util.Scanner;

public class DoWhileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");
		
		Scanner scanner = new Scanner(System.in);	//Scanner 객체 생성
		String inputString;		//입력받을 문자열 선언
		
		do {
			System.out.print(">");
			inputString = scanner.nextLine();	//키보드로 입력한 문자열을 받음, nextInt는 정수
			System.out.println(inputString);
		} while ( ! inputString.equals("q"));	//inputString이 q와 같지 않으면
		
		System.out.println();
		System.out.println("프로그램 종료.");
		
		int value;
		do {
			System.out.println("10보다 큰 숫자를 입력하세요.");
			value = scanner.nextInt();
		} while (value <= 10);
		System.out.printf("감사합니다, %d을 입력하셨습니다.", value );
	}

}
