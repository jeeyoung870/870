package hils.notification.websocket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Controller
public class NotificationController {

	
	@Autowired
	@Qualifier("notificationService")
	private INotificationService iNotificationService;
	
	public void setiNotificationService(INotificationService iNotificationService) {
		this.iNotificationService = iNotificationService;
	}

	@RequestMapping("goChatRoom")
	public String goChatRoom() {
		return "websocket";
	}
	@RequestMapping("goToNotiPage")
	public ModelAndView goToNotiPage(String[] notiData) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notification/seeNotiPage");
		mav.addObject("notiDataList", notiData);
		return mav;
	}
	//손봐야 한다. 지금 전체 삭제가 이루어진다.
	@RequestMapping("deleteEveryNoti")
	public String deleteEveryNoti(HttpServletRequest request) {
		String user_id = getUser_id(request);
		iNotificationService.deleteNotiService(user_id, null, null);
		
		return "redirect:/hils/main"; //mvc?
	}
	@RequestMapping("deleteSpecificNoti")
	public String deleteSpecificNoti(HttpServletRequest request, String rawDate, String noti_identifier) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		String user_id = getUser_id(request);
		Date date = null;
		if(rawDate != "") {
			try {
				date = simpleDateFormat.parse(rawDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		iNotificationService.deleteNotiService(user_id, date, noti_identifier);
		return "redirect:/hils/main";
	}
	private String getUser_id(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (String)session.getAttribute("Email");
	}
	
}
