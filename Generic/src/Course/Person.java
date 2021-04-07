package Course;

public class Person {
	private String name;
	public Person (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;	//이름을 문자열로 반환해주는 오버라이딩 메소드
	}

	
	
	
}
