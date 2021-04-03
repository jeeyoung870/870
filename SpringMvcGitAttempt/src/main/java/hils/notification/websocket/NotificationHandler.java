package hils.notification.websocket;

import java.text.SimpleDateFormat;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;

import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import hils.notification.model.GeneralNotiDto;

@Component("notificationHandler")
public class NotificationHandler extends TextWebSocketHandler implements DisposableBean{
	//set�̳� list�̳�		
	private Set<WebSocketSession> sessionSet= Collections.synchronizedSet(new HashSet<WebSocketSession>());
	
	private Map <String, WebSocketSession> userSessionMap =  Collections.synchronizedMap(new HashMap<String, WebSocketSession>());
	//not thread safe
	private boolean isConnectionEstablished;
	
	@Autowired
	@Qualifier("notificationService")
	private INotificationService iNotificationService;
	
	
	public void setiNotificationService(INotificationService iNotificationService) {
		this.iNotificationService = iNotificationService;
	}

	public boolean isConnectionEstablished() {
		return isConnectionEstablished;
	}

	public Map<String, WebSocketSession> getUserSessionMap() {
		return userSessionMap;
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		super.handleMessage(session, message);
	}

	@Override
	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handlePongMessage(session, message);
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return super.supportsPartialMessages();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("afterConnectionEstablished is called");
		System.out.println(getId(session));
		String user_id = getId(session);
		if(user_id != null) {
			userSessionMap.put(getId(session), session);
			
			String isThereNoti = iNotificationService.checkThereisNoti(user_id);
			System.out.println(isThereNoti);
			if(isThereNoti != null) {// && isThereNoti.equals("Y")
				List<GeneralNotiDto> generalNotiList = iNotificationService.selectUserNotiService(user_id);
				for(GeneralNotiDto notiDto : generalNotiList) {
					System.out.println("sending message from afterConnectionEstablished");
					session.sendMessage(new TextMessage(notiDto.getNoti_content() + notiDto.getNoti_identifier()));
				}
			}
			isConnectionEstablished = true;
		}
		
		super.afterConnectionEstablished(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandleTextMessage : " + session + ":" + message);
		String senderId = getId(session);
	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");
		GeneralNotiDto notiDto = new GeneralNotiDto();
		
		String msg = message.getPayload(); //msg = cmd, replywriter, boardwriter, b_number
		if(!StringUtils.isEmpty(msg)) {
			String[] strs = msg.split(",");
			System.out.println(strs.length);
			String cmd = strs[0];
			if(strs != null && strs.length == 6 && "reply".equals(cmd)) {
				
				String replyWriter = strs[1];
				String boardWriter = strs[2];
				String b_number = strs[3];
				String b_subject = strs[4];
				String c_reg_date = strs[5];
				WebSocketSession boardWriterwsSession = userSessionMap.get(boardWriter);
				String notiMessage = replyWriter + " 님이 " + b_subject + " 게시글에 답변을 달으셨습니다. 날짜는 :" + c_reg_date + ":";
				TextMessage textMessage = new TextMessage(notiMessage);
				if(boardWriterwsSession != null) {
					boardWriterwsSession.sendMessage(textMessage);
					System.out.println("sending from websockethandler and storing");
					//also stroing
					doInsertNoti(notiDto, notiMessage, boardWriter, simpleDateFormat.parse(c_reg_date));
//					notiDto.setUser_id(boardWriter);  //stored as boardWriter
//					
//					notiDto.setNoti_date();
//					notiDto.setNoti_content(notiMessage);
//					System.out.println("storing");
//					if(iNotificationService.insertNotiService(notiDto) == 0) {
//						System.out.println("insertion failed");
//					};
//					
				}else {
					
					doInsertNoti(notiDto, notiMessage, boardWriter, simpleDateFormat.parse(c_reg_date));
					
					
				}
			//OneOneAnswer : : : > cmd,user_id,reply_subject,reply_date
			}else if(strs != null && strs.length == 5 && "OneOneAnswer".equals(cmd)) {
				String receipent_id = strs[1];
				String ask_subject = strs[2];
				String reply_date = strs[3];
				WebSocketSession receipent_ws_session = userSessionMap.get(receipent_id);
				String notiMessage = receipent_id + " 님의 " + ask_subject + " 문의에 답변이 올라왔습니다. 날짜는 :" + reply_date + ":";
				TextMessage notiText = new TextMessage(notiMessage);
				if(receipent_ws_session != null) {
					receipent_ws_session.sendMessage(notiText);
					doInsertNoti(notiDto, notiMessage, receipent_id, simpleDateFormat.parse(reply_date));
				}else {
					doInsertNoti(notiDto, notiMessage, receipent_id, simpleDateFormat.parse(reply_date));
				}
				//LikeThumb : : : > cmd, thumbing user, thumbed user, b_number, board_subject
			}else if(strs!=null && strs.length == 5 && "likeThumb".equals(cmd)){
				String thumbing_user = strs[1];
				String thumbed_user = strs[2];
				String b_number = strs[3];
				String b_subject = strs[4];
				
				WebSocketSession thumbed_user_ws_session = userSessionMap.get(thumbed_user);
				Date currentServerTime = new Date();
				String thumbMessage = thumbing_user + " 님이 " + b_subject + " 게시글에 좋아요를 누르셨습니다. 날짜는:" + simpleDateFormat.format(currentServerTime) + ":";
				TextMessage notiText = new TextMessage(thumbMessage);
				
				if(thumbed_user_ws_session != null) {
					thumbed_user_ws_session.sendMessage(notiText);
					doInsertNoti(notiDto, thumbMessage, thumbed_user, currentServerTime);
				}else {
					doInsertNoti(notiDto, thumbMessage, thumbed_user, currentServerTime);
				}
			}
		}
		
		
		super.handleTextMessage(session, message);
	}
	private void doInsertNoti(GeneralNotiDto notiDto, String notiText, String user_id, Date date) {
		notiDto.setNoti_content(notiText);
		notiDto.setNoti_date(date);
		notiDto.setUser_id(user_id);
		if(iNotificationService.insertNotiService(notiDto) == 0) {
			System.out.println("insertion failed");
		};
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("error! in server side NotificationHandler");
		sessionSet.remove(session);
		userSessionMap.remove(getId(session));
		isConnectionEstablished = false;
		super.handleTransportError(session, exception);
	}

	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterConnectionClosed");
		sessionSet.remove(session);
		isConnectionEstablished = false;
		userSessionMap.remove(getId(session));
		super.afterConnectionClosed(session, status);
	}

	public Set<WebSocketSession> getSessionList() {
		return sessionSet;
	} 
	private String getId(WebSocketSession session) {
		Map<String, Object> attribute = session.getAttributes();
		String userId = (String)attribute.get("noti_user_id");
		return userId;
	}
	private void terminateGracefully() {
		System.out.println("terminateGracefully");
		sessionSet = Collections.synchronizedSet(new HashSet<WebSocketSession>());
		userSessionMap =  Collections.synchronizedMap(new HashMap<String, WebSocketSession>());
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		terminateGracefully();
	}

}
