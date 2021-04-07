package Airplane;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		Airplane2 a1 = new Airplane2();
		
		while(true) {
			int ap = scan.nextInt();
			if (ap == 1) {
				a1.setPlane(ap);
				a1.Lseat();
				break;
			}
			else if (ap == 2) {
				a1.setPlane(ap);
				a1.Aseat();
				break;
			}
			else System.out.print("다시 선택하세요.\n입력 > ");
		}
		
		a1.NameTempCheck();
		
		a1.land();
		a1.setHeight();
		a1.control();
		
		
	}
}













