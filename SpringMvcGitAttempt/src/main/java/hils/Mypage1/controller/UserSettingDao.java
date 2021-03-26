package hils.Mypage1.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Setter;

@Repository
@Setter
public class UserSettingDao {

	@Autowired
	SqlSession session;

	public List<ProfileDto> userInfo() {
		return session.selectList("usersetting.uInfo");
	}
	
	public String getPw(String user_id) {
		return session.selectOne("usersetting.getPw", user_id);
	}
	
	public int changePw(ProfileDto pdto) {
		return session.update("usersetting.changePw", pdto);
	}
	
	public String getPhone(String user_id) {
		return session.selectOne("usersetting.getPhone", user_id);
	}
	
	public int phoneCheck(String user_phone) {
		return session.selectOne("usersetting.phoneCheck", user_phone);
	}
	
	public int changePhone(ProfileDto pdto) {
		return session.update("usersetting.changePhone", pdto);
	}
	
	public int changeEmail(ProfileDto pdto) {
		return session.update("usersetting.changeEmail", pdto);
	}
	
	public int changeLoc(ProfileDto pdto) {
		return session.update("usersetting.changeLoc", pdto);
	}
	
	public int changeHilOpen(ProfileDto pdto) {
		return session.update("usersetting.changeHilOpen", pdto);
	}
	
	public int changeHilWB(ProfileDto pdto) {
		return session.update("usersetting.changeHilWB", pdto);
	}
}
