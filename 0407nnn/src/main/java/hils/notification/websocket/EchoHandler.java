package hils.notification.websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {

	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		sessionList.add(session);
		
//		logger.info("{} 연결됨", session.getId());
		super.afterConnectionEstablished(session);
		System.out.println("시스템 접속 완료");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		String payloadMessage = (String) message.getPayload();
		System.out.println(payloadMessage);
		session.sendMessage(new TextMessage("ECHO : " + payloadMessage));
		
	
	} 

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		super.handleTransportError(session, exception);
		System.out.println("접속 오류");
	}

//	@Override
//	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//		// TODO Auto-generated method stub
//		for (WebSocketSession sess : sessionList) {
//			sess.sendMessage(new TextMessage(session.getPrincipal().getName() + "|" + message.getPayload()));
//		}
//		super.handleTextMessage(session, message);
//	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		System.out.println("접속 종료");
	}

	@RequestMapping(value = "/chatting", method = RequestMethod.GET)
	public ModelAndView chat(ModelAndView mav) {
		mav.setViewName("chat/chattingview");
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		mav.addObject("userid", user.getUsername());
		return mav;
	}
}
