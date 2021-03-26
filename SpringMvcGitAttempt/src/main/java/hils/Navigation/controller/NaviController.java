package hils.Navigation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hils.Mypage1.controller.ProfileDto;
import hils.Mypage1.controller.SetProfileService;
import hils.Mypage1.controller.UserSettingService;
import hils.footer.controller.FooterService;
import lombok.Setter;

@Controller
@Setter
public class NaviController {
	
	@Autowired
	UserSettingService uset;
	
	@Autowired
	SetProfileService setp;
	
	//마이페이지
	@RequestMapping("mypage")
	public ModelAndView toMypage() {
		ProfileDto profileInfo = setp.profileInfo("jyjy");
		return new ModelAndView("mypage", "pInfo", profileInfo);
	}
	//내 알림
	@RequestMapping("myalarm")
	public String toMyalarm() {
		return "myalarm";
	}
	//나의 활동
	@RequestMapping("myActivitySchedule")
	public String toHistory() {
		return "myActivitySchedule";
	}
	//커뮤니티
	@RequestMapping("mainBoard")
	public String toCommunity() {
		return "mainBoard";
	}
	//타임라인
	@RequestMapping("timeline")
	public String toTimeline() {
		return "timeline";
	}
	//고객센터
	@RequestMapping("custcenter")
	public String toCustcenter() {
		return "custcenter";
	}
	//설정 및 회원정보
	@RequestMapping("usersetting")
	public ModelAndView toUsersetting() {
		List<ProfileDto> userInfo = uset.userInfo();
		return new ModelAndView("usersetting", "userInfo", userInfo);
	}
	//로그아웃
	@RequestMapping("logout")
	public String toLogout() {
		return "logout";
	}
	
}
