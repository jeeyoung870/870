package ListEx;

import java.util.*;		//모든 자바유틸 임포트

public class ArrayListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String> li = new ArrayList();
		
		li.add("java");
		li.add("jdbc");
		li.add("Servlet");		//원래 index2
		li.add(2, "database");	//index 2에 "database"저장 -->"Servlet"은 index3으로 밀려남.
		li.add("ibates");		//index4
		
		int s = li.size();
		System.out.println("총 객체수 : " + s);
		
		String skill1 = li.get(2);	//2번 인덱스 객체 얻기
		System.out.println(skill1);	//database
		
		String skill2 = li.get(0);	//0번 인덱스 객체 얻기
		System.out.println(skill2);
		
		for (int i = 0; i < li.size(); ++i) {
			System.out.println(i +":"+ li.get(i));
		}
		
		System.out.println();
		
		li.remove(2);	//index2삭제후--> 0:java, 1:jdbc, 2:Servlet, 3:ibates 이 됨.
		li.remove(3);	//변경된 index3(ibates)가 삭제됨!
		for (int i = 0; i < li.size(); ++i) {
			System.out.println(i +":"+ li.get(i));
		}
		
		System.out.println();
		
		li.add(0, "Servlet");
		for (int i = 0; i < li.size(); ++i) {
			System.out.println(i +":"+ li.get(i));
		}
		
		boolean b = li.get(0).equals(li.get(3));	//String이 같으면 true고,
		boolean c = (li.get(0) == li.get(3));	//같은 String은 new로 만들지 않는 이상 같다고 판단.
		System.out.println(b);
		System.out.println(c);
		
		System.out.println();
		
		
		//Arrays.asList()메소드
		//필요에 의해 객체를 추가하는게 아닌, 고정된 객체들로 생성된 List.
		//List <T> 배열명 = Arrays.asList(T ... 변수명);
		
		List<String> li1 = Arrays.asList("뮤뮤", "먀먀", "묘묘", "매매");
		
		for (String n : li1) {
			System.out.println(n);
		}
		
		List <Integer> li2 = Arrays.asList(1, 4, 3, 5);
		for (int i : li2) {
			System.out.println(i);
		}
		
		System.out.println();
		
		li2.remove(2);
		//System.out.println(li2.get(2));	//빨간줄은 없지만 삭제된 인덱스 출력시 컴파일오류
		//for (int m : li2) {				//고정된 객체를 지웠기 때문에 for문도 못 돌림.
			//System.out.println(m);
		//}
		
		
		
		
	}

}
