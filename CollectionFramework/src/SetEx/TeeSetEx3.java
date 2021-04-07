package SetEx;

import java.util.NavigableSet;
import java.util.TreeSet;

//<TreeSet이 가진 범위 검색 관련 메소드>
//NavigableSet<E> - headSet(element, boolean) : element보다 낮은 객체들을 NavigableSet으로 리턴.
// ㄴ boolean값에 따라 element포함 여부가 달라짐.
//NavigableSet<E> - tailSet(element, boolean) : element보다 높은 객체들을 ~~
//NavigableSet<E> - subSet(e1, b1, e2, b2) : e1과 e2사이의 객체들을 NavigableSet으로 리턴.
// ㄴ b1, b2 값에 따라 e1, e2의 컬렉션 포함 여부가 달라짐.

public class TeeSetEx3 {

	public static void main(String[] args) {
		//영어단어를 TreeSet에 무작위 저장하고, 알파벳 c~f사이의 단어 검색하기
		TreeSet<String> wordSet = new TreeSet<String>();
		wordSet.add("apple");
		wordSet.add("forever");
		wordSet.add("description");
		wordSet.add("ever");
		wordSet.add("zoo");
		wordSet.add("base");
		wordSet.add("fool");
		wordSet.add("cherry");
		
		System.out.println("< c~f 사이의 단어 검색 >");
		NavigableSet<String> nSet = wordSet.subSet("c", false, "f", true);
		//false라고 했는데 왜 컬렉션에 포함됨?;;
		for (String word : nSet) {
			System.out.println(word);
		}

	}

}
