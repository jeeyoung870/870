package Pair;

public class Util {		//다른 클래스의 객체를 매개변수로 사용하는 static 메소드
	public static <K, V> boolean compare (Pair p1, Pair p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
		//keyCompare와 valueCompare이 모두 true일때 true반환, 이외에는 false 반환.
	}

}
