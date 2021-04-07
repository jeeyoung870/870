import java.util.ArrayList;

public class Ex_01 {

	enum Lecture1 {java, javaSpring, Html};


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Lecture1 e : Lecture1.values()) {
			System.out.println(e);
		}
		
		int myAge;
		myAge = 25;
		System.out.println(myAge);
		myAge = (int)27.241414;
		System.out.println(myAge);

		//String [] rainbow = new String[7];	객체 선언
		String []rainbow = {"red", "orange", "yellow", "green", "blue", "navy", "purple"};
		for (String e : rainbow) {
			System.out.print(e + "  ");
		}System.out.println();
		System.out.println(rainbow[3]);
		
		ArrayList <String> lect = new ArrayList <String> ();
		lect.add("연산자");
		lect.add("변수선언");
		lect.add("객체지향");
		lect.add("제네릭");
		System.out.println("<강의과목>");
		for (String e : lect) {
			System.out.println(e);
		}System.out.println();
		
		for (int i = 0; i < lect.size(); ++i) {
			System.out.println(lect.get(i));
		}
	}
}
