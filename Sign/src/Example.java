
public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10, b = 20;
		int x = 100, y = 200;
		boolean result = (++a > ++b) && (++x < ++y);	//앞연산=false->뒷연산 계산 안함
		System.out.println(result);
		System.out.println(a);
		System.out.println(b);
		System.out.println(x);
		System.out.println(y);
		
		String str = "첫번째 문자열" + "두번째 문자열";
		System.out.println(str);
		
		String s1 = "당신을 사랑합니다.";
		String s2 = "당신을 사랑합니다.";
		boolean c = s1 == s2;
		System.out.println(c);
		

	}

}
