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
		System.out.println("����̸� �Է� : ");
		String ename = scan.next();
		
		List<EmpDto> x = dao.empFind(ename);
		if (x == null) {
			System.out.println("�ش��� ����");
		}else {
			System.out.println(x);
		}
	}
	
	public void empnoService() {	//trim()�ߴµ� �� �����ϸ� �ȵǴ���?
		Scanner scan = new Scanner(System.in);
		System.out.println("�����ȣ �Է�(','�� ����) : ");
		String nums = scan.next();
		
		StringTokenizer str = new StringTokenizer(nums, ",");
		for(int i = 0; i<str.countTokens(); i++){
	            int empno = Integer.parseInt(str.nextToken().trim());
			List<EmpDto> x = dao.empnoFind(empno);
			if (x == null) {
				System.out.println(empno + " -> �ش��� ����");
			}else {
				System.out.println(x);
			}
		}
	}

}
