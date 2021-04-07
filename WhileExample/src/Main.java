import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);	//입력값 받아오는 자바유틸
		
		int value;
		System.out.print("10보다 큰 수를 입력하세요. : ");
		value = scanner.nextInt();		//int인 숫자값을 받는 입력창 생성
		
		while (value <= 10) {
			System.out.print("잘못 입력하셨습니다. 10보다 큰 수를 입력하세요.");
			value = scanner.nextInt();	//계속해서 값을 받기
		}
		System.out.printf("감사합니다. %d를 입력하셨습니다.\n", value);
	}	//printf의 f는 formatted의 약자, 서식화된 출력만 지원한다는 의미
		//%d :  부호 있는 10진 정수를 담는 서식 지정자(=%i)// (%d, 값);으로 표기
}		//%c = 단일문자 //%s = 문자열 //%f = .이하 6자리까지 나타내는 실수
		//%u = 부호 없는 10진 정수 // %% = %(퍼센트) 기호 출력

	//println = 직관적 사용, 한줄엔터 포함.
	//print = 직관적 사용, 엔터 불포함.
	//printf = 서식화된 출력, 엔터 불포함.