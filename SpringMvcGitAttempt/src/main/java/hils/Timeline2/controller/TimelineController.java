package hils.Timeline2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TimelineController {
	//타임라인으로 이동
	@RequestMapping("timeline")
	public ModelAndView toTimeline(HttpServletRequest request) {
		//사용자 id 구하기
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email");
		
		//로그인 안했을경우
		if(user_id == null) {
			ModelAndView mav1 = new ModelAndView("loginform"); 
			return mav1;
		}else {		//로그인했을경우
			ModelAndView mav = new ModelAndView("timeline"); 
			return mav;
		}
	}
}
