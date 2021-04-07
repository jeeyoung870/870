package APIFunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//Predicate 함수적 인터페이스는 매개변수와 boolean 타입 리턴값이 있는 testXXX()메소드를 가짐.
//Predicate<T>	//boolean test(T t)		//객체 T를조사해 boolean타입 리턴
//BiPredicate<T, U>		//boolean test(T t, U u)	//객체 T와 U 비교조사
//DoublePredicate		//boolean test(double value)	//double값 조사
//IntPredicate 		//LongPredicate
public class PredicateIEx {
	//필드멤버로 list 생성
	private static List<Student> list = Arrays.asList(
			new Student("어쩌구", "여자", 90),
			new Student("저쩌구", "남자", 70),
			new Student("요쩌구", "여자", 90),
			new Student("거쩌구", "남자", 85)
			);
	private static List<Student> list2 = Arrays.asList(
			new Student("aed", "여자", 99),
			new Student("btbb", "남자", 69),
			new Student("wew", "여자", 89),
			new Student("bgd", "남자", 56)
			);
	
	public static double avg (Predicate<Student> pd) {
		int count = 0, sum = 0;
		for (Student s : list) {
			if (pd.test(s)) {		//Predicate<Student>타입 변수 pd가 true면,
				count++;
				sum += s.getScore();
			}
		} 
		return (double)sum/count;	
	}
	
	//실행
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double femaleAvg = avg (t -> t.getSex().equals("여자"));
		System.out.println("여자 평균 점수 : " + femaleAvg);
		
		double maleAvg = avg (t -> t.getSex().equals("남자"));
		System.out.println("남자 평균 점수 : " + maleAvg);

	}

}
