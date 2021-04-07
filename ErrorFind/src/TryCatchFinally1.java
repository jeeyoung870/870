
public class TryCatchFinally1 {
	public static void main(String [] args) {
		try {
			Class clazz = Class.forName("java.lang.String2");	//java.lang.String2=없는 클래스
		}
		catch (ClassNotFoundException e) {	//없는 클래스를 썼을 때의 예외처리
			System.out.println("클래스가 존재하지 않습니다.");
		}
		finally {
			System.out.println("있어도 되고 없어도 되는 finally 블록");
		}
	}

}
