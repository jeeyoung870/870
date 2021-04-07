package hils.ManageUser.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.Register.Model.RegisterDto;
import hils.Report.Model.PagingDto;
import hils.Report.Model.ReportDto;

@Service
public class ManageUserService {

	@Autowired
	private ManageUserDao manageUserDao;

	public void deleteMethod(String delete) {
		manageUserDao.deleteMethod(delete);
	}

	public void dormancyMethod(RegisterDto user_id) {
		manageUserDao.dormancyMethod(user_id);
	}
	
	public void dormancyCancleMethod(RegisterDto user_id) {
		manageUserDao.dormancyCancleMethod(user_id);
	}
	
	public int countMethod() {
		return manageUserDao.countMethod();
	}

	public List<RegisterDto> selectUserMethod(PagingDto registerPagingDto) throws Exception {
		return manageUserDao.selectUserMethod(registerPagingDto);
	}
}
