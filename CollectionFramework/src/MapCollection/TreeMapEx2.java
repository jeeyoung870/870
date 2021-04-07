package MapCollection;

import java.util.*;
import java.util.Map.Entry;

//<TreeMap이 가진 정렬 관련 메소드>
//NavigableSet<K> - descendingKeySet() : 내림차순으로 키가 정렬된 NavigableSet리턴.
//NavigableMap<K, V> - descendingMap() : 내림차순으로 정렬된 Map.Entry의 NavigableMap리턴.
//NavigableMap<K, V>은 Map컬렉션의 모든 메소드 + descendingMap()메소드를 추가로 제공한다.
//Map은 기본이 오름차순이지만,다시 오름차순으로 정렬하려면 descendingMap() 메소드를 두 번 호출하면 된다.
public class TreeMapEx2 {

	public static void main(String[] args) {
		//객체 정렬하기
		TreeMap<Integer, String> scores = new TreeMap<>();
		scores.put(87, "홍길동");
		scores.put(98, "이동수");
		scores.put(75, "박길순");
		scores.put(95, "신용권");
		scores.put(80, "김자바");
		
		//기본(오름차순)일때 : 낮은 점수가 first로 옴.
		System.out.println(scores.firstEntry().getValue() + " "+ scores.firstKey());
		
		//Map객체 내림차순정렬하기
		NavigableMap<Integer, String> nMap = scores.descendingMap();	

		//Map메소드인 entrySet()을 사용해 nMap의 Entry들을 Set타입으로 가져옴.
		Set<Map.Entry<Integer, String>> dEntrySet = nMap.entrySet();
		//??	??	??	??	??	??
		
		for (Map.Entry me : dEntrySet) {	//dEntrySet을 nMap.entrySet()이라고 써도됨
			System.out.println(me.getKey() +" - "+ me.getValue());
		}
		
		//Map유틸을 import하면 Entry 앞에 Map.도 생략가능하고
		Entry mp = scores.ceilingEntry(75);		//<Integer, String>도 생략가능하네?
		System.out.println(mp.getKey() +"  " + mp.getValue());
		//자동으로 타입유추 가능해서???? 아님 타입제한을 두지 않아서?
	}

}
