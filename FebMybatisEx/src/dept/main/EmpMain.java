package dept.main;

import java.util.List;

import dept.dao.EmpDao;
import dept.dto.EmpDto;
import dept.service.EmpService;
import dept.service.InsertService;


public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpService service = new EmpService();
		//service.findService();
		service.empnoService();
		
		EmpDao dao = new EmpDao();
		System.out.println("전체 사원은 " + dao.count() + "명 입니다.");
		
	}

}
