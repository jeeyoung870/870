package SetEx;

public class Member {
	public String name;
	public int age;
	
	public Member (String n, int a) {
		this.name = n;
		this.age = a;
	}

	@Override
	public int hashCode() {		//name과 age값이 같으면 동일한 hashCode가 리턴
		return name.hashCode() + age;
	}			//String의 hashCode()이용

	@Override
	public boolean equals(Object obj) {		////name과 age값이 같으면 true 리턴
		if (obj instanceof Member) {	//obj가 Member타입일 경우,
			Member mem = (Member)obj;
			return mem.name.equals(name) && (mem.age == age);
		}
		else {
			return false;
		}
	}
	
	

}
