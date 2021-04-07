package FunctionalInterfaceEx;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.Arrays;



//Function 함수적 인터페이스는 매개갑소가 리턴값이 있는 applyXXX()메소드를 사용.
//매개값을 받아 리턴값으로 매핑(타입 변환)하는 역할을 함.
//Function <T, R>	//R apply(T t)	//객체 T를 객체 R로 매핑
//BiFunction<T, U, R>	//R apply(T t, U u)	//객체 T와U를 R로 매핑
//DoubleFunctioner<R>	//R apply(double value)	//double -> R매핑
//IntFunction<R>	//R apply(int value)	//int -> R
//IntToDoubleFunction	//double applyAsDouble(int value)	//int -> double
//IntToLongFunction	//long applyAsLong(int value)	///int -> long
//LongToDoubleFunction	//double applyAsDouble(long value)	//long -> double
//LongToIntFunction		//int applyAsInt(long value)	//long -> int
//ToDoubleBiFunction	//double applyAsDouble(T t, U u)	//객체 T,U를 double로 매핑
//ToDoubleFunction<T>
//ToIntBiFunction<T, U> ----- ToIntFunction<T>
//ToLongBiFunction<T, U> ---- ToLongFunction<T>
public class FunctionIEx1 {
	//클래스의 필드 멤버로 Student 타입의 list 만들기
	private static List <Student> list = Arrays.asList(
			new Student ("홍길동", 90, 69), new Student ("어쩌구", 40, 90),
			new Student ("저쩌구", 80, 78), new Student ("요쩌구", 60, 99)
			);
			//Arrays.asList();는 ()안의 매개변수의 개수 관계없이 리스트를 만들어준다.
	public static void printString ( Function<Student, String> func) {
		for (Student s : list) {		//list에 저장된 수만큼 루핑
			System.out.print(func.apply(s) + "\t");
			//람다식 실행 : list배열 안의 Student 객체들을 String으로 매핑하여 출력한다.
		}
		System.out.println();
	}
	
	//Student타입을 Int로 매핑
	public static void printInt (ToIntFunction <Student> func) {
		for (Student s : list) {
			System.out.print(func.applyAsInt(s) + "\t");	//람다식 실행
		}
		System.out.println();
	}
	
	//실행
	public static void main(String [] args) {
		System.out.println("학생 이름 :");
		printString((n) -> n.getName());
		System.out.println("영어 점수 : ");
		printInt((t) -> t.getEnglishScore());
		System.out.println("수학 점수 :");
		printInt((m) -> m.getMathScore());
		
		for (Student s : FunctionIEx1.list) {
			System.out.println(s.getName());
			System.out.println(s.getEnglishScore());
			System.out.println(s.getMathScore());
		}
	}

}
