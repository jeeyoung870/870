package Airplane;

import java.util.Scanner;

public class Airplane1 {	//탑승
	
	private int setP;	//국내,국제선 선택
	public int Lseat = 20;	//국내선 정원
	public int Aseat = 30;	//국제선 정원
	private int getTk;	//탑승인원
	private int corona =0;
	
	
	public Airplane1 () {
		System.out.print("어서오세요. 여객기를 선택하세요.\n1 : 국내선(김포->제주)\t2 : 국제선(김포->나리타)\n입력 > ");
	}
	
	public void setPlane(int ap) {
		setP = ap;
		if(ap == 1) {
			System.out.println("국내선 승선권을 발매합니다.");
		}else System.out.println("국제선 승선권을 발매합니다.");
	}
	
	public int getSetP() {
		return setP;
	}

	Scanner scan = new Scanner(System.in);
	public void getTickets () {	
		System.out.print("탑승인원 입력 > ");
		int tkn = scan.nextInt(); scan.nextLine();
		getTk = tkn;
	}
	
	public void Lseat () {
		while (true) {
			getTickets();
			if(getTk > 20) {
				System.out.println("좌석이 모자랍니다. 다시 입력");
			}else if (getTk < 1) {
				System.out.println("잘못 입력하셨습니다.");
			} else 
				break;
			
		}	
		
	}
	public void Aseat () {
		while (true) {
			getTickets();
			if(getTk > 30) {
				System.out.println("좌석이 모자랍니다. 다시 입력");
			}else if (getTk < 1) {
				System.out.println("잘못 입력하셨습니다.");
			} else 
				break;
		}	
	}
	
	int i;
	public void NameTempCheck () {
		for (i=0; i < getTk; ++i) {
			System.out.print("승객" + (i+1) + " 성함 입력 : ");
			String name = scan.nextLine();
			System.out.print(name + "님 체온 입력 : ");
			int temp = scan.nextInt(); scan.nextLine();	//nextLine은 입력후 엔터까지 받지만, nextInt는 마지막 엔터를 안 받고
			if (temp >= 37) {							//다음 스캐너로 넘겨주므로 찌꺼기 엔터를 받아먹는 nextLine을 끼워줘야 오류가 없다.
				System.out.println("체온 37도 이상인 " + name + "님은 탑승불가합니다.");
				++corona;
				continue;
			}
		}System.out.println("승선권을 " + (getTk-corona) + "매 발매합니다. 즐거운 여행 되십시오.\n");
		
	}
	
}
