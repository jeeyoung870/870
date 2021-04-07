package ListEx;
import java.util.*;
public class LinkedListEx {		//ArrayList와의 실행 성능 비교

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LinkedList는 ArrayList와 사용방법은 같지만 구조가 다름.
		//빈번한 객체 삭제와 삽입이 일어나는 리스트라면 LinkedList가 더 성능이 좋다.
		//끝에서부터 추가/삭제하는 경우는 ArrayList가, 
		//중간에 추가/삭제하는 경우는 LinkedList가 유리하다.
		//ArrayList는 뒤쪽 인덱스들을 모두 1씩 증감하는 시간이 필요하기 때문이다.
		
		List<String> li1 = new ArrayList<>();
		List<String> li2 = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; ++i) {
			li1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		
		System.out.println("ArrayList 걸린 시간 : " + (endTime - startTime) + " ns");
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; ++i) {
			li2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린 시간 : " + (endTime - startTime) + " ns");

	}

}
