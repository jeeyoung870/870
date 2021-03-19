package hils.Mypage1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaveController {
	
	@RequestMapping("leave")
	public String leave() {
		return "reallyWithdraw";
	}
	@RequestMapping("leavesure")
	public String leaveSure() {
		return "goodbye";
	}

}
