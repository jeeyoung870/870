package Box;

public class BoxingMethodEx {

	public static void main(String[] args) {
		Box<Integer> b1 = Util.<Integer>boxing(100);
		//Util클래스의static메소드 호출. 객체 없이도 사용가능
		int iValue = b1.get();
		
		Box<String> b2 = Util.boxing("something");
		String str = b2.get();
		
		System.out.println(iValue + "  " + str);

	}

}
