package Comparable;

//Comparable 인터페이스는 Integer, Double, String에서 구현된다.
//메소드 : 객체.compareTo(T o)		-리턴타입: int
//(객체)와 같으면 0리턴, (객체)보다 크면 양수 리턴, (객체)보다 작으면 음수 리턴

//implements를 통해 사용자 정의 클래스에도 Comparable을 구현할 수 있다.
//대신 compareTo(객체) 메소드를 Override(재정의)해야 함.
public class Person implements Comparable<Person> {
	private String name;
	private int age;
	
	public Person (String n, int age) {
		this.name = n;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}


	@Override	//Comparable<Person>을 implements하면 재정의해야 하는 메소드
	public int compareTo(Person o) {
		if (age < o.age)
			return -1;		//(객체)의 나이보다 작으면 -1리턴
		else if (age == o.age)
			return 0;		//(객체)의 나이와 같으면 0리턴
		else return 1;		//(객체)의 나이보다 크면 1리턴
	}

}
