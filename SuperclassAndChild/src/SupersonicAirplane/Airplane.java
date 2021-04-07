package SupersonicAirplane;

public class Airplane {	// public final class로 만들 경우 상속할 수 없는 클래스가 됨.
						//public final void로 메소드를 만들면 재정의(오버라이딩)할 수 없는 최종메소드가 됨
	public void land() {
		System.out.println("착륙합니다.");
	} 
	public void fly() {
		System.out.println("일반비행합니다.");
	}
	public void takeOff() {
		System.out.println("이륙합니다.");
	}

}
