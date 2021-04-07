package dept.service;

import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import dept.dao.EmpDao;
import dept.dto.EmpDto;


public class EmpService {
	
	EmpDao dao = new EmpDao();
	
	public void findService() {
		Scanner scan = new Scanner(System.in);
		System.out.println("사원이름 입력 : ");
		String ename = scan.next();
		
		List<EmpDto> x = dao.empFind(ename);
		if (x == null) {
			System.out.println("해당사원 없음");
		}else {
			System.out.println(x);
		}
	}
	
	public void empnoService() {	//trim()했는데 왜 띄어쓰기하면 안되는지?
		Scanner scan = new Scanner(System.in);
		System.out.println("사원번호 입력(','로 구분) : ");
		String nums = scan.next();
		
		StringTokenizer str = new StringTokenizer(nums, ",");
		for(int i = 0; i<str.countTokens(); i++){
	            int empno = Integer.parseInt(str.nextToken().trim());
			List<EmpDto> x = dao.empnoFind(empno);
			if (x == null) {
				System.out.println(empno + " -> 해당사원 없음");
			}else {
				System.out.println(x);
			}
		}
	}

}
