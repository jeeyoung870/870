package Comparable;

import java.util.*;

public class ComparableEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Person> p = new TreeSet<>();
		
		p.add(new Person("홍길동", 45));
		p.add(new Person("김자바", 27));
		p.add(new Person("박지영", 25));
		p.add(new Person("어쩌구", 57));	//나이 오름차순으로 정렬됨.
		
		Iterator<Person> personI = p.iterator();	//반복자생성
		while (personI.hasNext()) {
			Person person = personI.next();
			System.out.println(person.getName() + " : " + person.getAge());
		}
		
		

	}

}
