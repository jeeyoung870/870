package MapCollection;

import java.util.*;

public class HashMapEx1 {

	public static void main(String[] args) {
		//HashMap : Map인터페이스를 구현한 대표적인 Map컬렉션.
		//Map <K, V> 객체명 = new HashMap<K, V>(); 로 생성한다.
		//K(키)의 값에 V(밸류)를 저장하는 식으로 만들어진다.
		
		//Map컬렉션 생성
		Map <String, Integer> stuMap = new HashMap<>();
		
		//객체 저장
		stuMap.put("Mary", 85);
		stuMap.put("Paul", 70);
		stuMap.put("July", 90);
		stuMap.put("Paul", 89);		//"Paul"키가 같기 때문에 제일 나중에 저장한 값(89)로 대치.
		System.out.println("총 Entry 수 : " + stuMap.size()); //3으로 출력.
		
		//객체 찾기
		System.out.println("\tMary : " + stuMap.get("Mary"));	//이름으로 점수 리턴
		System.out.println("\tPaul : " + stuMap.get("Paul"));
		System.out.println("\tJuly : " + stuMap.get("July"));
		System.out.println();
		
		//객체 하나씩 처리
		Set<String> sKeySet = stuMap.keySet();	//keySet()메소드로 Map의 키 얻기
		Iterator <String> keyI = sKeySet.iterator();	//반복자 생성
		while (keyI.hasNext()) {
			String key = keyI.next();
			int val = stuMap.get(key);
			System.out.println("\t" + key + " : " + val);
		}
		System.out.println();
		
		//객체 삭제
		stuMap.remove("Mary");
		System.out.println("총 Entry 수 : " + stuMap.size());
		
		//객체 하나씩 처리
		Set<Map.Entry<String, Integer>> eSet = stuMap.entrySet();	//stuMap의 entrySet얻기
		Iterator<Map.Entry<String, Integer>> entryI = eSet.iterator(); //반복자 생성
		while (entryI.hasNext()) {
			Map.Entry<String, Integer> e = entryI.next(); //다음요소가 있다면 한 칸 앞으로
			String key = e.getKey();
			int val = e.getValue();
			System.out.println("\t" + key + " : " + val);
		}
		System.out.println();
		
		//객체 전체 삭제
		stuMap.clear();
		System.out.println("총 Entry 수 : " + stuMap.size());

	}

}
