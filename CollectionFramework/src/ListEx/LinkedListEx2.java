package ListEx;

import java.util.*;

public class LinkedListEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> li1 = new LinkedList<>();
		li1.add("Amy");
		li1.add("Carl");
		li1.add("Erica");
		List<String> li2 = new LinkedList<>();
		li2.add("Bob");
		li2.add("Doug");
		li2.add("Frances");
		li2.add("Gloria");
		li2.add("fig");
		
		//b를 a로 병합
		ListIterator<String> li1ter = li1.listIterator();
		//Iterator : 전체 객체를 대상으로 한 번씩 반복해서 가져오는 반복자
		Iterator<String> li2ter = li2.iterator();
		while (li2ter.hasNext()) {	//li2ter.hasNext() :더 지나갈 요소가 있는 한 true반환.
			if (li1ter.hasNext())
				li1ter.next();	//null->0 index인 Amy로 이돔
			li1ter.add(li2ter.next());	//li1[0]인 Amy바로뒤에 Bob(li2[0]) 추가.
		}
	//요소가 더 많은 List가 while()에 들어가고, 적은 List가 if()에 들어가야 빠짐없이 합칠 수 있다.
		
		System.out.println("li1 : " + li1);
		System.out.println("li2 : " + li2);
		
		//li2에서 짝수번째 요소 삭제
		li2ter = li2.iterator();
		while (li2ter.hasNext()) {	//다음주자가 있다면,
			li2ter.next();		//1)li2[0] =첫번째로 이동	2)li2[2]=Frances로 이동
			if (li2ter.hasNext()) {
				li2ter.next();	//1)li2[1] =두번째로 이동	2)li2[3]=Gloria로 이동
				li2ter.remove();	//1)li2[1]=두번째 삭제	2)li2[3]=Gloria 삭제
			}
		}
		System.out.println("li2 : " + li2);	
		
		//li2ter = li2.iterator();
		//while (li2ter.hasNext()) {
			//li2ter.next();
			//li2ter.remove();
		//}
			//위 코드는 li2.clear();와 똑같은 결과를 냄. 요소 모두 삭제.
		
		//li1에서 li2와 겹치는 모든 단어 삭제
		li1.removeAll(li2);
		System.out.println("li1 : " + li1);
		
		//li1속 요소들 모두 삭제 --> 출력하면 []라고 나옴.
		li1.clear();
		System.out.println("li1 : " + li1);

	}

}
