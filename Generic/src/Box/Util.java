package Box;

public class Util {
	public static <T> Box<T> boxing(T t) {		//Box<T>의 <T>는 생략가능
		Box<T> box = new Box();
		box.set(t);
		return box;
		
	}
}
