
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//명령문이 하나일때는 중괄호 없어도 되지만 두개 이상이면 중괄호 써야 함.
		//위에 쓰여 있는 조건문부터 맞는지 계산함. 부합하면 아래 조건문은 비교X
		int score;
		int rate;
		String result;
		score = 89;
		
		if(score > 90)
			rate = 1;
		else if(score > 80)
			rate = 2;
		else if (score >70)
			rate = 3;
		else 
			rate = 4;
		
		switch(rate) {
		case 1 :
			result = "아주 훌륭합니다.";
			break;
		case 2 : 
			result = "참 잘했어요.";
			break;
		case 3 :
			result = "좋습니다.";
			break;
		default : 		//if문의 else와 같음.
			result = "분발하세요.";
		}	
		
		System.out.println(result);
		
	}

}
