package hils.ManageUser.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.Register.Model.RegisterDto;

@Service
public class ManageUserService {

	@Autowired
	private ManageUserDao manageUserDao;

	public List<RegisterDto> selectMethod() throws Exception {
		return manageUserDao.selectMethod();
	}

	public void deleteMethod(String delete) {
		manageUserDao.deleteMethod(delete);
	}

}
