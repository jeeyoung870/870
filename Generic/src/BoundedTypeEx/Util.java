package BoundedTypeEx;

public class Util {
	public static <T extends Number> int compare (T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
	}
	//doubleValue()와 Double.compare();은 자바의 Double 클래스가 제공하는 메소드

}
