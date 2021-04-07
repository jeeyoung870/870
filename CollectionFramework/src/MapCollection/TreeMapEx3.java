package MapCollection;

import java.util.*;

//TreeMap 인터페이스는 TreeSet과 동일한 범위 검색 메소드를 가지고 있다.
//리턴 타입 : NavigableMap<K, V>	(동일)
//headMap(key, boolean)		-key보다 낮은 Map.Entry들을 리턴 
//tailMap(key, boolean)		-key보다 높은 Map.Entry들을 리턴
//subMap(key1, boolean, key2, boolean)	-키1과 키2 사이의 Map.Entry를 컬렉션에 리턴.

public class TreeMapEx3 {

	public static void main(String[] args) {
		//무작위로 저장한 영어단어와 페이지를 TreeMap에 저장하고, 알파벳 c~f사이의 단어 검색.
		
		TreeMap <String, Integer> wordMap = new TreeMap<>();
		wordMap.put("apple", 10);
		wordMap.put("forever", 60);
		wordMap.put("description", 40);
		wordMap.put("ever", 50);
		wordMap.put("zoo", 10);
		wordMap.put("base", 20);
		wordMap.put("fool", 70);
		wordMap.put("cherry", 30);
//List와 Set은 add()메소드, Map은 put()메소드.
		
		System.out.println("< c~f 사이의 단어 검색 >");		//true라했는데 왜 포함안됨?
		NavigableMap<String, Integer> nm = wordMap.subMap("c", true, "f", true);
		
		//NavigableMap 타입의 nm에 .entrySet()메소드를 적용하면 for문으로 바로 돌릴 수 있다!
		//NavigableMap이나 NavigableSet타입은 entrySet()을 거쳐야 Entry를 뽑아올 수 있음. 
		for (Map.Entry word : nm.entrySet()) {
			System.out.println(word.getKey() + " : " + word.getValue() + " page");
		}
	}

}
