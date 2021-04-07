package dept.service;

import java.util.Scanner;

import dept.dao.DeptDao;
import dept.dto.DeptDto;

public class InsertService {
	//console창에 입력한 값들을 db에 저장하고, insertDAO메소드 호출
	DeptDao dao = new DeptDao();
	
	public void updateService() {
		Scanner scan = new Scanner(System.in);
		System.out.println("부서 번호 입력 : ");
		int deptno = scan.nextInt();
		System.out.println("부서 위치 입력 : ");
		String loc = scan.next();
		
		int x = dao.updateLoc(deptno, loc); 
		
		if(x == 0) {
			System.out.println("해당번호 부서 없음");
		}else {
			System.out.println(deptno + "번 부서의 위치가 " + loc + "으로 변경됨.");
		}
	}
	
	public void insertService() {
		Scanner scan = new Scanner(System.in);
		System.out.println("부서 번호 입력 : ");
		int deptno = scan.nextInt();
		System.out.println("부서 이름 입력 : ");
		String dname = scan.next();
		System.out.println("부서 위치 입력 : ");
		String loc = scan.next();
		
		DeptDto dto = new DeptDto();
		dto.setDeptno(deptno);
		dto.setDname(dname);
		dto.setLoc(loc);
		
		int x = dao.insertDept(dto);
		
		if (x == 0) {
			System.out.println("부서번호 다시 입력");
		} else{
			System.out.println("insert성공");
		}
		
	}
	
	public void deleteService() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 부서 번호 입력 : ");
		int deptno = scan.nextInt();
		
		int x = dao.deleteDept(deptno); 
		
		if(x == 0) {
			System.out.println("해당번호 부서 없음");
		}else {
			System.out.println(deptno + "번 부서가 삭제됨.");
		}
	}
}
