package MyFunctionalInterfaceEx;
//인터페이스 MyFunc를 사용하는 클래스
public class UsingLocalVar {	//Final 특성을 갖는 로컬 변수
	//람다식에서 외부 클래스의 필드, 메소드는 제한 없이 사용 가능하나, 
	//메소드의 매개 변수, 로컬 변수를 사용하려면 이들은 Final 특성을 가져야 한다.
	
	void method (int arg) {	//arg는 Final 특성을 가짐
		int localVar = 40;	//localVar는 Final 특성을 가짐
		
		//arg = 31;			//Final 특성을 가졌기 때문에 수정불가.수정하면 람다식에서 사용불가.
		//localVar = 41;	//위와 같음
		
		//람다식
		MyFunc mf = () -> {
			//로컬 변수 읽기
			System.out.println("arg : " + arg);
			System.out.println("localVar : " + localVar);
		};
		
		mf.method();
	}
	
	//실행
	public static void main (String [] args) {
		UsingLocalVar ulv = new UsingLocalVar();
		
		ulv.method(20);
	}
}
