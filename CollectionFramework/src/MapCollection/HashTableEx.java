package MapCollection;

import java.util.*;

public class HashTableEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String , String> login = new Hashtable <> ();
		
		login.put("spring", "123");
		login.put("summer", "432");
		login.put("fall", "765");
		login.put("winter", "876");		//id와 pw
		
		Scanner scan = new Scanner(System.in);	//스캐너 객체 생성
		
		while (true) {
			System.out.println("아이디와 비밀번호를 입력해 주세요.");
			System.out.println("아이디 : ");
			String id = scan.nextLine();	//키보드로 아이디 입력받기
			
			System.out.println("비밀번호 : ");
			String pw = scan.nextLine();
			System.out.println();
			
			if (login.containsKey(id)) {
				if (login.get(id).equals(pw)) {		//id(키)로 불러온 value와 pw비교
					System.out.println("로그인 성공");
					break;
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}else {
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
			}
		}
	}

}
