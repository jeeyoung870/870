package FunctionalInterfaceEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class FunctionalIEx2 {
	//Student타입 객체들을 갖는 List<Student>타입 필드 생성.
	private static List<Student> list = Arrays.asList(
			new Student ("홍길동", 90, 69), new Student ("어쩌구", 40, 90),
			new Student ("저쩌구", 80, 78), new Student ("요쩌구", 60, 99)
			);

	public static double avg (ToIntFunction<Student> func) {
		int sum = 0;
		for (Student s : list) {
			sum += func.applyAsInt(s);
		}
		double average = (double) sum / list.size();
		return average;
	}
	
	//실행
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//FunctionalIEx2 fi = new FunctionalIEx2();		같은 클라스라서 선언 생략?
		double englishAvg = avg (e -> e.getEnglishScore());	//avg()메소드
		System.out.println("영어 점수 평균 : " + englishAvg);
		double mathAvg = FunctionalIEx2.avg(m -> m.getMathScore());//FunctionalIEx2생략가능
		System.out.println("수학 점수 평균 : " + mathAvg);
		
	}

}
