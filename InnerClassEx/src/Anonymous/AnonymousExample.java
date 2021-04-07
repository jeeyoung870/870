package Anonymous;

public class AnonymousExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Anonymous anony = new Anonymous();
		anony.field.wake();	//익명 개체 필드 사용
		anony.method1(); 	//익명 개체 로컬변수 사용
		anony.method2(
				new Person () {	//메소드처럼 객체사용..?			//여기부터
					void study() {//메소드
						System.out.println("공부합니다.");
					}
					@Override
					void wake () {
						System.out.println("8시에 일어납니다.");
						study();
					}										//여기까지가 매개값
				});
		

	}

}
