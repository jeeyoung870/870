package Cellphone;

public class Main {

	public static void main(String[] args) {
		// DmbCellphone 객체 생성
		DmbCellphone Cell1 = new DmbCellphone ("자바폰", "검정", 10);
		
		//Cellphone에서 public으로 만든 필드 사용가능. private로 만들면 사용불가.
		System.out.println("모델 : " + Cell1.model);
		System.out.println("색상 : " + Cell1.color);
		//DmbCellphone의 필드
		System.out.println("채널 : " + Cell1.channel);
		
		//Cellphone에서 상속받은 메소드 호출
		Cell1.powerOn();
		Cell1.bell();
		Cell1.sendVoice ("여보세요.");
		Cell1.recieveVoice("안녕하세요! 저는 어쩌구인데요.");
		Cell1.sendVoice("아예 반갑습니다.");
		Cell1.hangUp();
		//DmbCellphone의 메소드 호출
		Cell1.turnOnDmb();
		Cell1.changeChannelDmb(12);
		Cell1.turnOffDmb();

	}

}
