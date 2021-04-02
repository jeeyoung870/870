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
	
	//�α׾ƿ�
	@RequestMapping("logout")
	public String toLogout() {
		return "logout";
	}
	
}
