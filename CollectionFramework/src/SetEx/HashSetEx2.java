package SetEx;

import java.util.*;

public class HashSetEx2 {
	public static void main(String[] args) {
		
		HashSet<Member> memSet = new HashSet<>();
		
		memSet.add(new Member("어쩌구", 30));
		memSet.add(new Member("어쩌구", 30));	
		//Member 클래스에서 재정의한 boolean equals()메소드에 의해서 동일객체 간주
		//인스턴스는 다르지만(new 연산자), 내부 데이터가 동일하므로, 객체 1개만 저장됨
		
		System.out.println("총 객체수 : " + memSet.size());
	}

}
