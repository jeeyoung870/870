package CallListener;

public class ButtonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Button btn = new Button();
		
		btn.setOnClickListener(new CallListener());
		btn.touch();
		
		btn.setOnClickListener(new MessageListener());
		btn.touch();
		//어떤 구현 객체를 생성하느냐에 따라서 touch()메소드의 실행 결과가 달라진다.
	}

}
