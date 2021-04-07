package SupersonicAirplane;

public class SupersonicAExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SupersonicA sa = new SupersonicA();
		sa.takeOff();
		sa.fly();
		sa.flyMode = SupersonicA.SUPERSONIC;
		sa.fly();
		sa.flyMode = SupersonicA.NORMAL;
		sa.fly();
		sa.land();
	}

}
