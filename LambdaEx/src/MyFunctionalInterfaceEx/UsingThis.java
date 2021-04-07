package MyFunctionalInterfaceEx;

public class UsingThis {  	//인터페이스 MyFunc를 사용하는 클래스
	public int outterField = 10;
	
	class Inner {
		int innerField = 20;
		
		void method() {
			//람다식
			MyFunc mf = () -> {
				System.out.println("OutterField : " + outterField);
				System.out.println("OutterField : " + UsingThis.this.outterField + "\n");
					//클래스 바깥의 객체를 참조하기 위해서는 클래스명.this를 사용
				System.out.println("innerField : " + innerField);
				System.out.println("innerField : " + this.innerField + "\n");
			};		//람다식 내부에서 this는 람다식이 속한 클래스 내부의 객체 참조
			
			mf.method();
		}
	}
	
	//실행
	public static void main(String [] args) {
		UsingThis usingThis = new UsingThis(); 
		UsingThis.Inner inner = usingThis.new Inner();	//내부클래스 Inner의 객체생성
		inner.method();
	}

}
