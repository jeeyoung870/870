import java.util.Scanner;

public class Ex_03 {

	private int score;
	public void setScore(int s) {
		this.score = s;
	}
	public int getScore() {
		return score;
	}
	
	static int rate;
	public int getRate() {
		if (score >= 90 && score <= 100) {
			rate = 1;
		}else if (score >= 80 && score < 90) {
			rate = 2;
		}else if (score >= 70 && score < 80) {
			rate = 3;
		}else if (score >= 0 && score < 70) {
			rate = 4;
		}else  rate = 0;
		return rate;
	}
	
	private String msg;
	public void showMsg () {
		switch (rate) {
		case 1 :{
			msg = getRate() + " 등급 - 아주 훌륭합니다.";
			System.out.println(msg);
			break;
		}case 2 :{
			msg = getRate() + " 등급 - 참 잘했습니다.";
			System.out.println(msg);
			break;
		}case 3 :{
			msg = getRate() + " 등급 - 좋습니다.";
			System.out.println(msg);
			break;
		}case 4 :{
			msg = getRate() + " 등급 - 분발하세요.";
			System.out.println(msg);
			break;
		}case 0 :{
			msg = "잘못 입력하셨습니다.";
			System.out.println(msg);
			break;
		}
		}
	}
	public String getMsg() {
		return msg;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex_03 rating = new Ex_03();
		
		while (true) {
			System.out.print("점수 입력 > ");
			Scanner scan = new Scanner(System.in);
			int score = scan.nextInt();
			
			if (score == 999) {
				System.out.println("종료합니다.");
				break;
			}
			rating.setScore(score);
			rating.getRate();
			rating.showMsg();
		}
	}

}
