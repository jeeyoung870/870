package SetEx;

import java.util.*;

public class HashSetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Set 컬렉션 : 객체 배열저장. List와 다르게 index가 없고(순서저장x), 중복저장 불가.
		//집합과 같은 개념.
		//Iterator 사용가능
		//HashSet : Set 인터페이스의 구현 클래스. 순서없이 저장, 동일객체 중복저장x
		//같은 문자열을 갖는 String 객체는 동등객체.(.equals()메소드)

		Set<String> set = new HashSet<>();
		set.add("java");
		set.add("jdbc");
		set.add("Servlet");
		set.add(new String("java"));
		set.add("ibatis");
		
		int size = set.size();	//set에 저장된 객체의 수 얻기
		System.out.println("총 객체수 : " + size);	
		//"java"는 new로 저장해도 .equals()메소드에 의해 같은 객체로 인식됨. 4 출력.
		
		Iterator <String> setI = set.iterator();
		//반복자 얻기.list에서는 index를 쓰기 때문에 ListIterator를, 
		//HashSet에서는 index없으므로 Iterator 사용.
		while (setI.hasNext()) {
			String element = setI.next();
			System.out.println(element);
		}	//순서관계없이 출력됨.
		
		set.remove("jdbc");		//한 개의 객체 삭제
		
		System.out.println("총 객체수 : " + set.size());
		
		setI = set.iterator();		//위에서 생성한 반복자 새로 얻기(초기화)
		while (setI.hasNext()) {
			System.out.println(setI.next());
		}
		
		set.clear(); 	//모든 객체 제거
		if (set.isEmpty()) {	//set객체가 비어 있다면,
			System.out.println("비어 있음.");
			}
		
		
	}

}
