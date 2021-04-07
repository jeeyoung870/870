package MapCollection;

public class Student {	//키로 사용할 객체 - hashCode()와 equals() 재정의
	public int sno;
	public String name;
	
	public Student (int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public int hashCode() {		//학번과 이름이 같다면 동일한 값을 리턴
		return sno + name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {		//학번과 이름이 같을 경우 true리턴
		if (obj instanceof Student) {
			Student stu = (Student) obj;
			return (sno == stu.sno) && (name.equals(stu.name));
		}else {
			return false;
		}
	}
	//hashCode()와 boolean equals() 모두를 재정의 해줘야,
	//같은 학번과 이름을 가진 Student 객체를 Map안에서 같은 객체로 취급할 수 있다.
	//키로 사용할 객체의 클래스에서는 재정의해주는게 좋다.
	

}
