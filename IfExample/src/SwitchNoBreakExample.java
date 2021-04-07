
public class SwitchNoBreakExample {		//break;문이 없는 case

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time = (int)(Math.random() * 4) + 8;	//8<=~<=11사이의 정수 뽑기
		System.out.println("[현재시간: " + time + " 시]");
		
		switch (time) {
		case 8 : 
			System.out.println("출근합니다.");
		case 9 :
			System.out.println("회의를 합니다.");
		case 10 :
			System.out.println("업무를 봅니다.");
		case 11 :
			System.out.println("외근을 나갑니다.");
		}		//break;문이 없으면 case값과는 상관없이 연달이 출력된다.
	}

}
