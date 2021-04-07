package Point;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r1 = Util.min(10, 20);
		System.out.println(r1);
		
		double r2 = Util.min(100.245, 100.255);
		System.out.println(r2);
		String r3 = Util.min("당신을", "사랑합니다");		//더 짧은 문자열을 자갇고 인식
		System.out.println(r3);
		Point r4 = Util.min(new Point(10, 20), new Point(100, 200));
		System.out.println(r4.getX() + " : " + r4.getY());	//그냥 r4라고하면 좌표값으로 안나옴

	}

}
