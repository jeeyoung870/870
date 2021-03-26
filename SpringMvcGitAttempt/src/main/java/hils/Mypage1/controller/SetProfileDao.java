package hils.Mypage1.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Setter;

@Repository
@Setter
public class SetProfileDao {
	
	@Autowired
	SqlSession session;
	
	public ProfileDto profileInfo(String user_id) {
		return session.selectOne("usersetting.profileInfo", user_id);
	}
	
	public int addImgFile(ProfileDto pdto) {
		return session.update("usersetting.addImgFile", pdto);
	}
	
	public String findProfileImg(String user_id) {
		return session.selectOne("usersetting.findProfileImg", user_id);
	}

}
