import java.awt.Point;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack <Character> sc = new Stack <Character> (10);	//Stack클래스의 10개의 <char>타입 배열
		IStack <Point> sp = new Stack <Point> (6); 		//좌표타입(int, int)
		
		sc.push('c');
		char c = sc.pop();
		System.out.println(c);
		
		sp.push(new Point (10, 20));
		sp.push(new Point (30, 40));
		sp.push(new Point (50, 60));
		sp.push(new Point (70, 80));
		sp.push(new Point (90, 100));
		sp.push(new Point (110, 120));
		int size = sp.size();
		for (int i = 0; i < size; ++i) {
			Point p = sp.pop();
			System.out.println(p);
		}
		
		
		//sc.push(200.23);		//에러. sc는 Character타입만 쓸 수 있음.
		//sp.push("문자열");		//에러. sp는 Point 타입만 쓸 수 있음.
		
		Stack <Integer> si = new Stack <Integer>(10);
		si.push(20);
		si.push(100);
		si.push(1000);
		Stack <Integer> si2 = new Stack <Integer> (10);
		si2.push(1000);
		si2.push(1300);
		boolean b = si2.compareSize(si); 	//b==false
		System.out.println(b);
		
		int size1 = si.size();
		for (int i = 0; i < size1; ++i) {
			int r = si.pop();
			System.out.println(r);
		}
	}

}
