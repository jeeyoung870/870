package hils.notification.websocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Controller
public class NotificationController {

//	@Autowired
//	private NotificationHandler notificationHandler;
//	
//	public void setNotificationHandler(NotificationHandler notificationHandler) {
//		this.notificationHandler = notificationHandler;
//	}
	@RequestMapping("goChatRoom")
	public String goChatRoom() {
		return "websocket";
	}
	@RequestMapping("sendNoti")
	@ResponseBody
	public void sendNoti() {
		
	}
}
