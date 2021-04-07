package hils.Mypage1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LeaveController {
	
	@Autowired
	UserSettingService uset;
	
	@RequestMapping("leave")
	public ModelAndView leave(String user_id) {
		return new ModelAndView("reallyWithdraw", "user_id", user_id);
	}
	@RequestMapping("leavesure")
	public ModelAndView leaveSure(String user_id) {
		int succ = uset.leaveHils(user_id);
		System.out.println(succ);
		if(succ == 0) {
			System.out.println("delete user fail");
		}else {
			System.out.println("delete user success");
		}
		//로그아웃시키기
		return new ModelAndView("goodbye");
	}

}
