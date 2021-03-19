package hils.Mypage1.controller;

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
}
