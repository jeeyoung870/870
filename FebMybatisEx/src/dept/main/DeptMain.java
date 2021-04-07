package dept.main;


import java.util.List;

import dept.dao.DeptDao;
import dept.dto.DeptDto;
import dept.service.InsertService;

public class DeptMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InsertService service = new InsertService();
		//service.insertService();
		//service.updateService();
		//service.deleteService();
		
		
		DeptDao dao = new DeptDao();
		System.out.println("��ü �μ��� " + dao.count() + "�� �Դϴ�.");
		List<DeptDto> list = dao.deptAll(); 
		
		for(DeptDto d : list) {
			System.out.println(d);
		}

	}

}
