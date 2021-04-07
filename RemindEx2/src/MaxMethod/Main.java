package MaxMethod;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> sc = new Stack<Character>(10);
		sc.push('가');
		char rc = sc.pop();
		System.out.println(rc);
		Stack<Point> sp = new Stack<Point>(5);
		sp.push(new Point(10, 20));
		Point rp = sp.pop();
		System.out.printf("x = %d, y = %d\n", rp.getX(), rp.getY());
		
		Map<Integer, String> map = new Map<Integer, String>(5);
		for (int i = 0; i < 5; ++i)
			map.push(i, "문자열"+i);
		String s= map.get(3);
		System.out.println(s);
		Map<Double, String> map2 = new Map<Double, String>(5);
		
		sc.push('나');
		rc = sc.pop();
		System.out.println(rc);
		
		int i = min(100, 200);
		double d = min(200.1, 300.1);
		s = min("당신을", "사랑합니다.");
		System.out.printf("i = %d, d = %g, s = %s\n", i, d, s);
		
		Stack<Integer> si1 = new Stack<Integer>(10);
		si1.push(100);
		si1.push(200);
		Stack<Integer> si2 = new Stack<Integer>(10);
		si2.push(1000);
		boolean b = si2.compareSize(si1);
		System.out.println(b);
		b = si2.compareSize(sp);
	}
	
	
	public static <T extends Comparable<T>> T min(T x, T y) {
		return x.compareTo(y) < 0 ?  x : y;
	}
	

	
	//<T extends Comparable<T>> 의 <T>는 생략가능
}

