package hils.notification.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class NotificationHandler extends TextWebSocketHandler{
	//set이냐 list이냐		
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	private Map <String, WebSocketSession> userSessionMap = new HashMap<String, WebSocketSession>();
	
	private boolean isConnectionEstablished;
	
	public boolean isConnectionEstablished() {
		return isConnectionEstablished;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		sessionList.add(session);
		System.out.println("afterConnectionEstablished is called");
		isConnectionEstablished = true;
		super.afterConnectionEstablished(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("error! in server side NotificationHandler");
		isConnectionEstablished = false;
		super.handleTransportError(session, exception);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		sessionList.remove(session);
		isConnectionEstablished = false;
		super.afterConnectionClosed(session, status);
	}

	public List<WebSocketSession> getSessionList() {
		return sessionList;
	} 
	
	

}
