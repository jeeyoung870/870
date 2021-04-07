
public class FieldInitValueExample {	//필드값 출력
	public static void main (String[] args) {
		
		FieldInitValue fiv = new FieldInitValue();	//자바파일에서 값을 가벼온다고 선언 
		
		System.out.println("byteField : " + fiv.byteField);
		System.out.println("shortField : " + fiv.shortField);
		System.out.println("intField : " + fiv.intField);
		System.out.println("longField : " + fiv.longField);
		System.out.println("booleanField : " + fiv.booleanField);
		System.out.println("charField : " + fiv.charField);
		System.out.println("floatField : " + fiv.charField);
		System.out.println("doubleField : " + fiv.doubleField);
		System.out.println("arrField : " + fiv.arrField);
		System.out.println("referenceField : " + fiv.referenceField);
		//출력되는 값은 각 필드의 타입별 초기값.
		
		fiv.floatField = 3.28f;	//float값이면 f붙여야됨
		System.out.println(fiv.floatField);
	}	
}
