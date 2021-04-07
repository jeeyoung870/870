package MapCollection;

import java.util.Map;
import java.util.TreeMap;

//TreeMap은 이진 트리 기반 Map컬렉션.
//key와 value가 저장된 Map.Entry를 저장함.
//HashMap과의 차이점 : 범위 검색 메소드를 사용가능.
//TreeMap에 객체를 저장하면 자동으로 정렬됨.
//TreeMap<K(키 타입), V(값 타입)> 객체변수명 = new TreeMap<>();	//TreeMap생성

//<TreeMap의 검색 메소드>(타입명은 Map.Entry<K, V> 로 모두 같음)
//Map.Entry<K, V> - firstEntry() : 제일 낮은 Map.Entry리턴
//		"		  - lastEntry() : 제일 높은 Map.Entry리턴
//lowerEntry(key) : 주어진 키의 바로 아래 Entry리턴
//higherEntry(key) : 키의 바로 위 Entry리턴
//floorEntry(key) : 주어진 키의 Entry 리턴, 없으면 바로 아래의 Entry리턴
//ceilingEntry(key) : 주어진 키의 Entry리턴, 없으면 바로 위의 Entry리턴
//pollFirstEntry() : 가장 낮은 Entry 꺼내 컬렉션에서 삭제
//pollLastEntry() : 가장 높은 Entry 꺼내 컬렉션에서 삭제

public class TreeMapEx1 {

	public static void main(String[] args) {
		//점수를 key, 이름을 value로 무작위 저장하고, 특정Map.Entry 찾기
		TreeMap<Integer, String> scores = new TreeMap<>();
		scores.put(87, "홍길동");
		scores.put(98, "이동수");
		scores.put(75, "박길순");
		scores.put(95, "신용권");
		scores.put(80, "김자바");
		
		Map.Entry<Integer, String> sEntry = null;	//Entry는 Map컬렉션에서만 쓸 수 있는 타입.
		
		sEntry = scores.firstEntry();
		System.out.println("가장 낮은 점수 : " + sEntry.getKey() + " - " + sEntry.getValue());
		
		sEntry = scores.lastEntry();
		System.out.println("가장 높은 점수 : " + sEntry.getKey() +" - "+ sEntry.getValue());
		
		sEntry = scores.lowerEntry(95);
		System.out.println("95점 미만 점수 : " + sEntry.getKey() +" - "+ sEntry.getValue() );
		
		sEntry = scores.higherEntry(95);
		System.out.println("95점 초과 점수 : " + sEntry.getKey()+" - "+ sEntry.getValue());
		
		sEntry = scores.floorEntry(95);
		System.out.println("95점이거나 바로 아래 점수 : "
				+ sEntry.getKey() + " - "+ sEntry.getValue());
		
		sEntry = scores.ceilingEntry(95);
		System.out.println("95점이거나 바로 위의 점수 : "
				+ sEntry.getKey() + " - " + sEntry.getValue());
		
		while (! scores.isEmpty()) {
			Map.Entry<Integer, String> ent = scores.pollFirstEntry();
			//왜 타입명 Map.Entry<Integer, String>은 생략이 가능한지?
			System.out.println(ent.getKey()+"점인 " + ent.getValue() + " 삭제");
			System.out.println("남은 객체 수 : " + scores.size());
		}
		

	}

}
