package SetEx;

import java.util.*;

//<TreeSet이 가진 정렬 관련 메소드>
//Iterator<E> - descendingIterator() : 내림차순으로 정렬된 Iterator를 리턴.
//NavigableSet<E> - descendingSet() : 내림차순으로 정렬된 NavigableSet을 반환.

//NavigableSet은 TreeSet과 똑같은 검색 메소드 + descendingSet()메소드도 제공한다.
//오름차순으로 정렬하고 싶다면, descendingSet()메소드를 두 번 호출하면 된다.

public class TreeSetEx2 {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(65);
		scores.add(95);
		
		NavigableSet <Integer> descend = scores.descendingSet();//검색메소드로 정렬객체생성
		System.out.print("높은 점수부터 -> ");
		for (Integer s : descend) {
			System.out.print(s + "  ");
		}
		
		System.out.println();
		
		NavigableSet <Integer> ascend = descend.descendingSet();
		//내림차순 정렬객체인 descend에 내림차순메소드 descendingSet()사용하면 차순반전됨.
		System.out.print("낮은 점수부터 -> ");
		for (int s : ascend) {
			System.out.print(s + "  ");
		}
		

	}

}
