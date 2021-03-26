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
	
	//����������
	@RequestMapping("mypage")
	public ModelAndView toMypage() {
		ProfileDto profileInfo = setp.profileInfo("jyjy");
		return new ModelAndView("mypage", "pInfo", profileInfo);
	}
	//�� �˸�
	@RequestMapping("myalarm")
	public String toMyalarm() {
		return "myalarm";
	}
	//���� Ȱ��
	@RequestMapping("myActivitySchedule")
	public String toHistory() {
		return "myActivitySchedule";
	}
	//Ŀ�´�Ƽ
	@RequestMapping("mainBoard")
	public String toCommunity() {
		return "mainBoard";
	}
	//Ÿ�Ӷ���
	@RequestMapping("timeline")
	public String toTimeline() {
		return "timeline";
	}
	//������
	@RequestMapping("custcenter")
	public String toCustcenter() {
		return "custcenter";
	}
	//���� �� ȸ������
	@RequestMapping("usersetting")
	public ModelAndView toUsersetting() {
		List<ProfileDto> userInfo = uset.userInfo();
		return new ModelAndView("usersetting", "userInfo", userInfo);
	}
	//�α׾ƿ�
	@RequestMapping("logout")
	public String toLogout() {
		return "logout";
	}
	
}
