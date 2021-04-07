
public class Ex_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10, b = 20;
		int x = 100, y = 200;
		boolean result = (++a > ++b) && (++x < ++y); //논리곱.하나라도 false면 false
		System.out.println(a);
		System.out.println(b);
		System.out.println(x);	//a, b까지만 증감하고 이후의 식은 계산할 필요 없어서 연산 안함
		System.out.println(y);
		System.out.println(result);
		
		String one = "첫번째 문자열", two = "두번째 문자열";
		String str = one + two;
		System.out.println(str);
		String three = "첫번째 문자열";
		String four = new String ("첫번째 문자열"); //new 선언으로 새로운 객체 만듬
		
		boolean b1 = one == three;
		System.out.println(b1);
		boolean b2 = one.equals(three);
		System.out.println(b2);
		
		boolean b3 = one == four;
		System.out.println(b1);
		boolean b4 = one.equals(four);
		System.out.println(b2);
		
	}

}
