import java.util.Scanner;

public class TestRate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int score;
		
		do {
			System.out.print("점수입력 > ");
			score = scanner.nextInt();
			if (score == 999) 
				break;
			if (score > 100) {
				System.out.println("오류! 다시 입력하세요.");
				continue;	//맨위로 올라감
			}
			System.out.println();
			
			int rate = 0;		//1, 2, 3, 4등급에 해당하는 점수 외에는 0
			
			if (score >= 90 && score <= 100) 
				rate = 1;
			else if (score >= 80 && score < 90) 
				rate = 2;
			else if (score >= 70 && score < 80)
				rate = 3;
			else if (score >= 0 && score < 70) 
				rate = 4;
			
			System.out.println("등급 : " + rate);
			
			String msg = null;	//null =초기화
			switch(rate) {
			case 1 :	//1등급이라면
				msg = "아주 훌륭합니다.";
				break;
			case 2 :
				msg = "참 잘했습니다.";
				break;
			case 3 :
				msg = "좋습니다.";
				break;
			case 4 :
				msg = "분발하세요.";
				break;
			}	
			System.out.println(msg);
			System.out.println("종료하려면 999 입력");
		} while (true);	
		System.out.println("종료합니다.");
		
	}

}
