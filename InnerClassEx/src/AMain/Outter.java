package AMain;
//로컬 클래스(메소드 속 클래스)에서의 사용제한
//로컬 클래스에서 사용된 매개 변수와 로컬변수는 모두 final특성을 갖는다.
public class Outter {
	
	//자바 7이전
	public void method1(final int arg) {
		final int localVar = 1;
		//arg = 100;
		//localVar = 100;	//final이므로 재정의 불가능
		class Inner{
			public void method() {
				int result = arg + localVar;
				System.out.println(arg +" + " + localVar + " = " + result);
			}
		}
		Inner i = new Inner();
		i.method();
	}
	
	//자바 8 이후
	public void method2(int arg) {
		int localVar = 100;
		//arg = 100;
		//localVar = 10;	//final 특성을 가지므로, 재정의 불가능
		class Inner{
			public void method() {
				int result = arg + localVar;
				System.out.println(arg +" + " + localVar + " = " + result);
			}
		}
		Inner i = new Inner();
		i.method();
	}

}
