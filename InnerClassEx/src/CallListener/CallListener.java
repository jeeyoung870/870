package CallListener;

public class CallListener implements Button.OnClickListener {
	//Button클래스의 중첩 인터페이스인 OnClickListener를 구현
	
	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		System.out.println("전화를 겁니다.");
	}

}
