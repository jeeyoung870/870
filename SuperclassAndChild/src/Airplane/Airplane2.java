package Airplane;

import java.util.Scanner;

public class Airplane2 extends Airplane1 {	//비행
	private int maxHeight;
	private int minHeight;
	private int currentHeight = 26000;
	
	public void setHeight () {
		if (getSetP() == 1) {
			maxHeight = 28000; 
			minHeight = 22000;
		}
		else {
			maxHeight = 42000; 
			minHeight = 26000;
		}
	}
	
	public void land() {
		System.out.println("\n>>>>여객기 이륙<<<<");
		System.out.println("우리 여객기는 상공" + currentHeight + "피트에서 순항 중입니다.");
	}
	
	public void plusHeight() {
		currentHeight += 1000;
		if (currentHeight > maxHeight) {
			currentHeight = maxHeight;
			System.out.println("현재 최고 고도" + currentHeight + "피트 입니다.");
		}
		else System.out.println("우리 여객기는 상공" + currentHeight + "피트에서 순항 중입니다.");
	}
	public void minusHeight() {
		currentHeight -= 1000;
		if (currentHeight < minHeight) {
			currentHeight = minHeight;
			System.out.println("현재 최저 고도" + currentHeight + "피트 입니다.");
		}
		else System.out.println("우리 여객기는 상공" + currentHeight + "피트에서 순항 중입니다.");
	}
	
	Scanner scan = new Scanner(System.in);

	public void control () {
		while(true) {
			System.out.printf("1. 상승\t2. 하강\t3. 착륙\n선택 > ");
			int con = scan.nextInt();
			if (con == 1) {
				plusHeight();
				continue;}
			else if (con == 2) {
				minusHeight();
				continue;}
			else if (con == 3) {
				System.out.println("\n>>>>여객기 착륙<<<<");
				if (getSetP() == 1) {
					System.out.println("즐거운 제주여행 되세요.");
				}
				else {System.out.println("즐거운 일본여행 되세요.");}
				break;}
			else System.out.println("잘못 입력하셨습니다."); 
		}
	}
	
	
}
