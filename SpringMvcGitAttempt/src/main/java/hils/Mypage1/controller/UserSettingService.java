package hils.Mypage1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingService {
	
	@Autowired
	UserSettingDao dao;
	
	public List<ProfileDto> userInfo() {
		return dao.userInfo();
	}
	
	public String getPw(String user_id) {
		return dao.getPw(user_id);
	}
	
	public int changePw(String oldpw, String newpw) {
		return dao.changePw();
	}

}
