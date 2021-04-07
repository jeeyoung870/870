//생성자에서 필드 초기화
public class Korean {
	//필드
	String nation = "대한민국";
	String name;
	String ssn;
	String sex;
	
	//생성자(다른 파일에서 불러올 수 있음)
	public Korean(String n, String s, String x) {
		name = n;	//n = name; <-하면 안됨.
		ssn = s;
		sex = x;
	}

}
