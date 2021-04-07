package StackEx;
import java.awt.Point;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack <Character> sc = new Stack <Character> (10);
		Stack <Point> sp = new Stack <Point> (6);
		
		sc.push('c');
		sc.push('a');
		sc.push('t');
		sc.push('L');
		sc.push('O');
		sc.push('V');
		sc.push('E');
		
		sp.push(new Point (10, 12));
		sp.push(new Point (20, 330));
		sp.push(new Point (30, 21));
		
		System.out.println(sc.compareSize(sp));
		
		int j = sc.size();
		System.out.println(j);
		for (int i = 0; i < j; ++i) {
			System.out.println(sc.pop());
		}
		
		int k = sp.size();
		System.out.println(k);
		for (int i = 0; i < k; ++i) {
			System.out.println(sp.pop());
		}
		
		
	}

}
