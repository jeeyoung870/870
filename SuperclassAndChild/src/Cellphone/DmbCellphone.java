package Cellphone;

public class DmbCellphone extends Cellphone {
	//필드
	int channel;
	//생성자
	public DmbCellphone (String md, String col, int chan) {
		this.model = md;
		this.color = col;	//model, color는 Cellphone에서 상속받은 필드
		this.channel = chan;
	}
	//메소드
	public void turnOnDmb() {
		System.out.println("채널 : " + channel + "번의 DMB 방송 수신을 시작합니다.");
	}
	void changeChannelDmb (int chNum) {
		this.channel = chNum;
		System.out.println("채널 " + channel + "번으로 바꿉니다.");
	}
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}

}
