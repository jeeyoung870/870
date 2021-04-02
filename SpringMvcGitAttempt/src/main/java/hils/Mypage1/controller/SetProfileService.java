package hils.Mypage1.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class SetProfileService {

	@Autowired
	SetProfileDao dao;
	
	public void setDao(SetProfileDao dao) {
		this.dao = dao;
	}

	
	
	
	public ProfileDto profileInfo(String user_id) {
		return dao.profileInfo(user_id);
	}
	
	public void addImgFile(String user_id, String path) {
		ProfileDto pdto = new ProfileDto();
		pdto.setUser_id(user_id);
		pdto.setProfile_img(path);
		int x = dao.addImgFile(pdto);
		if (x == 0) {
			System.out.println("insert fail");
		}else {
			System.out.println("insert success");
		}
	}
	
	public String findProfileImg(String user_id) {
		return dao.findProfileImg(user_id);
	}
	
	public Date latestdate(String user_id) {
		return dao.latestdate(user_id);
	}
	
	public ProfileDto workoutInfo1(ProfileDto pdto) {
		return dao.workoutInfo1(pdto);
	}
	
	public List<ProfileDto> workoutInfo2(ProfileDto pdto) {
		return dao.workoutInfo2(pdto);
	}
	
	public List<ProfileDto> dietInfo(String workout_key) {
		return dao.dietInfo(workout_key);
	}
	
	public int changePInfo(ProfileDto pdto) {
		return dao.changePInfo(pdto);
	}
	
	public int delpimg(String user_id) {
		return dao.delpimg(user_id);
	}
}
