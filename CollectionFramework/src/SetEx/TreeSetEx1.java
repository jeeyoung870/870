package SetEx;
import java.util.TreeSet;
		//Set인터페이스로 저장해도 되지만, 
		//TreeSet클래스 타입은 객체를 찾거나 범위검색과 관련된 메소드를 사용할 수 있다.
		//Set타입이라서 index, 중복은 저장 안함.
		

		//<TreeSet이 가진 검색관련 메소드>

		//first() - 제일 낮은 객체 리턴		//last() - 제일 높은 객체 리턴
		//lower(E e) - 주어진 객체보다 바로 아래 객체 리턴 (리턴<e)
		//higher(E e) - e 바로 위의 객체 리턴 (리턴>e)
		//floor(E e) - e와 동등한 객체가 있으면 리턴, 없으면 바로 아래 객체 리턴(리턴<=e)
		//ceiling(E e) - e와 동등한 객체 리턴, 없으면 바로 위 객체 리턴. (리턴>=e)
		//pollFirst() - 제일 낮은 객체 꺼내 컬렉션에서 제거
		//pollLast() - 제일 높은 객체 꺼내 컬렉션에서 제거
public class TreeSetEx1 {

	public static void main(String[] args) {	//무작위로 점수 저장하고 특정 점수 찾기
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);	
		scores.add(new Integer(60));	//중복아니라서 객체로는 인식하는데 왜 Integer취소처리됨?
		scores.add(97);	
		scores.add(79);
		scores.add(87);		//중복이라서 저장 안함.
		
		Integer s = null;	//int가 아닌 참조타입 Integer로 만들면 null값 참조가능
		
		System.out.println("객체 수 : " + scores.size());
		
		System.out.println("가장 낮은 점수 : " + scores.first());
		
		System.out.println("가장 높은 점수 : " + scores.last());
		
		System.out.println("95점 미만 점수 : " + scores.lower(95));
		System.out.println("60점 초과 점수 : " + scores.higher(60));	//60은 포함안됨.
		
		System.out.println("87점 이상 점수 : " + scores.ceiling(87));	//포함
		System.out.println("79점 이하 점수 : " + scores.floor(79));	//포함
		
		while (! scores.isEmpty()) {	//컬렉션이 비어있지 않다면,
			int sc = scores.pollLast();		//제일 높은점수 삭제
			System.out.println(sc + "삭제 - 남은 객체 수 : " + scores.size());
		}
		
		//while (!scores.isEmpty()) {	//컬렉션이 비어있지 않다면,
			//s = scores.pollFirst();		//제일 낮은 점수 꺼내 제거
			//System.out.println(s + " (남은 객체 수 : " + scores.size() + ")");
		//}
		
		
		

	}

}
