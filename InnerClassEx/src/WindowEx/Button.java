package WindowEx;

public class Button {	//UI class
	public OnClickListener listener;	//인터페이스 타입으로 필드 선언
	
	void setOnClickListener (OnClickListener listener) { //인터페이스 타입으로 객체 받음 
		this.listener = listener;
	}
	
	void touch () {
		listener.onClick();
	}
	
	interface OnClickListener {	//중첩 인터페이스
		void onClick();
	}
	
}
