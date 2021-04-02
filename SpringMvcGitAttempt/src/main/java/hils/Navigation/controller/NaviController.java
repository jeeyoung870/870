package hils.Navigation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import hils.Mypage1.controller.SetProfileService;
import hils.Mypage1.controller.UserSettingService;
import lombok.Setter;

@Controller
@Setter
public class NaviController {
	
	@Autowired
	UserSettingService uset;
	
	@Autowired
	SetProfileService setp;
	
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
	
	//로그아웃
	@RequestMapping("logout")
	public String toLogout() {
		return "logout";
	}
	
}
