package hils.Mypage1.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Setter;

@Repository
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
	
	public Date latestdate(String user_id) {
		return session.selectOne("usersetting.latestdate", user_id);
	}
	
	public ProfileDto workoutInfo1(ProfileDto pdto) {
		return session.selectOne("usersetting.workoutInfo1", pdto);
	}
	
	public List<ProfileDto> workoutInfo2(ProfileDto pdto) {
		return session.selectList("usersetting.workoutInfo2", pdto);
	}
	
	public List<ProfileDto> dietInfo(String workout_key) {
		return session.selectList("usersetting.dietInfo", workout_key);
	}

	public int changePInfo(ProfileDto pdto) {
		return session.update("usersetting.changePInfo", pdto);
	}
	
	public int delpimg(String user_id) {
		return session.update("usersetting.delpimg", user_id);
	}

	
	
	
	
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
}
