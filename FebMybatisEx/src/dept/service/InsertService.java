package dept.service;

import java.util.Scanner;

import dept.dao.DeptDao;
import dept.dto.DeptDto;

public class InsertService {
	//consoleâ�� �Է��� ������ db�� �����ϰ�, insertDAO�޼ҵ� ȣ��
	DeptDao dao = new DeptDao();
	
	public void updateService() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�μ� ��ȣ �Է� : ");
		int deptno = scan.nextInt();
		System.out.println("�μ� ��ġ �Է� : ");
		String loc = scan.next();
		
		int x = dao.updateLoc(deptno, loc); 
		
		if(x == 0) {
			System.out.println("�ش��ȣ �μ� ����");
		}else {
			System.out.println(deptno + "�� �μ��� ��ġ�� " + loc + "���� �����.");
		}
	}
	
	public void insertService() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�μ� ��ȣ �Է� : ");
		int deptno = scan.nextInt();
		System.out.println("�μ� �̸� �Է� : ");
		String dname = scan.next();
		System.out.println("�μ� ��ġ �Է� : ");
		String loc = scan.next();
		
		DeptDto dto = new DeptDto();
		dto.setDeptno(deptno);
		dto.setDname(dname);
		dto.setLoc(loc);
		
		int x = dao.insertDept(dto);
		
		if (x == 0) {
			System.out.println("�μ���ȣ �ٽ� �Է�");
		} else{
			System.out.println("insert����");
		}
		
	}
	
	public void deleteService() {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �μ� ��ȣ �Է� : ");
		int deptno = scan.nextInt();
		
		int x = dao.deleteDept(deptno); 
		
		if(x == 0) {
			System.out.println("�ش��ȣ �μ� ����");
		}else {
			System.out.println(deptno + "�� �μ��� ������.");
		}
	}
}
