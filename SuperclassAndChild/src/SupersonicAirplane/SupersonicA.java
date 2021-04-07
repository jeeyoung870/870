package SupersonicAirplane;

public class SupersonicA extends Airplane {	//자식클래스 
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;	//final : 바꿀 수 없는 최종값 선언
	
	public int flyMode = NORMAL;	//초기값=1
	
	@Override
	public void fly() {
		if (flyMode == SUPERSONIC) {
			System.out.println("초음속비행합니다.");
		}else {
			super.fly();	//Airplane 객체의 fly()메소드 호출
		}
	}

}
