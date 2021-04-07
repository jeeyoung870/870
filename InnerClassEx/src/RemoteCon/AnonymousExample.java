package RemoteCon;

public class AnonymousExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anonymous anony = new Anonymous();
		//익명 개체필드 사용
		anony.field.turnOn();
		//익명 개체 로컬 변수 사용
		anony.method1();
		//익명 개체 매개값 사용
		anony.method2(
				new RemoteControl() {

					@Override
					public void turnOn() {
						System.out.println("SmartTv를 켭니다.");
						
					}

					@Override
					public void turnOff() {
						System.out.println("SmartTv를 끕니다.");
						
					}
					
				});

	}

}
