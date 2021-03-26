package hils.Mypage1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
@Setter
public class SetProfileService {

	@Autowired
	SetProfileDao dao;
	
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
}
