
public class Member {	//필드=다룰 정보들의 종류 선언
	String name;
	String phone;
	int month;
	
	public Member(String n, String p, int m) {	//생성자=입력받을 방법
		name = n;
		phone = p;
		month = m;
	}
	
	public void printMember() {		//메소드=클라스 외부에서 호출할 수 있음(단축키처럼 사용가능)
		System.out.printf("회원명 : %s \n번호 : %s \n수강 : %d개월\n", name, phone, month);
	}

}
