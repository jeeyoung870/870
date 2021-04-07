package Point;

public class Util {
	public static <T extends Comparable <T>> T min (T x, T y) {
		return x.compareTo(y) < 0? x : y;
	}

}
