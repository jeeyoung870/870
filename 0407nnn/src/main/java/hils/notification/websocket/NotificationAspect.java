package hils.notification.websocket;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import hils.notification.model.CommentNotiDto;
import hils.notification.model.GeneralNotiDto;
import hils.notification.model.LikeNotiDto;
import hils.notification.model.ReplyNotiDto;

@Aspect
@Component("notificationAspect")
public class NotificationAspect {
	
	@Autowired
	@Qualifier("notificationService")
	private INotificationService iNotificationService;
	
	
	@Autowired
	@Qualifier("notificationHandler")
	private NotificationHandler notificationHandler;
	
	public void setNotificationHandler(NotificationHandler notificationHandler) {
		this.notificationHandler = notificationHandler;
	}

	public void setiNotificationService(INotificationService iNotificationService) {
		this.iNotificationService = iNotificationService;
	}

	//doNoti on comment
	public Object doNoti(JoinPoint joinpoint, Object returnValue) throws Throwable {
		HttpServletRequest request = null;
		request = helperExtractRequest(joinpoint);
		//Joinpoint.getArgs() only get arguments of method... so the target must must must have HttpServletRequeset as Argument/parameter
        try{
            HttpSession session = request.getSession();
            CommentNotiDto commentNotiDto = (CommentNotiDto)session.getAttribute("commentNotiDto");
            
            if(commentNotiDto != null) {
				Map <String ,WebSocketSession> wsSessionMap = notificationHandler.getUserSessionMap();
				WebSocketSession  wsSess = wsSessionMap.get((String)session.getAttribute("Email"));
				
				if(wsSess != null) {
					try {	
						System.out.println("sending message from aspect");
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");
						//textMessage should be splited by ","
						TextMessage textMessage = new TextMessage("reply," + commentNotiDto.getReplyWriter() + "," + commentNotiDto.getBoardWriter() + "," + commentNotiDto.getB_number()  + "," 
						+ commentNotiDto.getB_subjet() + "," + simpleDateFormat.format(commentNotiDto.getComment_reg_date()));
					    notificationHandler.handleTextMessage(wsSess, textMessage);
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
            }else {
            	
            }
        }catch(Exception e){
        	
        }
      
		return returnValue;
	}
	//extract HttpServletRequest from joinpoint
	private HttpServletRequest helperExtractRequest(JoinPoint joinpoint) {
		HttpServletRequest request = null;
		for ( Object o : joinpoint.getArgs()){
            if ( o instanceof HttpServletRequest ) {
                request = (HttpServletRequest)o;
            }
        }
		return request;
	}
	
//	public Object distributeNoti(JoinPoint joinpoint, Object returnValue) {
//		HttpServletRequest request = helperExtractRequest(joinpoint);
//		try {
//			HttpSession session = request.getSession();
//			String user_id = (String)session.getAttribute("Email");
//			List<GeneralNotiDto> notiList = iNotificationService.selectUserNotiService(user_id);
//			session.setAttribute("notiList", notiList);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return returnValue;
//	}
	//doNoti on OneVOne Reply
	public Object doReplyNoti(JoinPoint joinpoint, Object returnValue) {
		HttpServletRequest request = helperExtractRequest(joinpoint);
		try {
			HttpSession session = request.getSession();
			ReplyNotiDto replyNoti = (ReplyNotiDto) session.getAttribute("replyNoti");
			
			if(replyNoti != null) {
				Map<String, WebSocketSession> wsSessionMap = notificationHandler.getUserSessionMap();
				WebSocketSession wsSession = wsSessionMap.get((String)session.getAttribute("Email"));
				
				if(wsSession != null) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");
					TextMessage textMessage = new TextMessage("OneOneAnswer," + replyNoti.getUser_id() + "," + 
					replyNoti.getAsk_subject() + "," + simpleDateFormat.format(replyNoti.getReply_date())
							);
					notificationHandler.handleMessage(wsSession, textMessage);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	//doNoti on LikeThumb 
	public Object doLikeNoti(JoinPoint joinpoint, Object returnValue) {
		HttpServletRequest request = helperExtractRequest(joinpoint);
		try {
			HttpSession session = request.getSession();
			LikeNotiDto likeNoti = (LikeNotiDto)session.getAttribute("likeNoti");
				
			if(likeNoti != null) {
				Map<String, WebSocketSession> wsSessionMap = notificationHandler.getUserSessionMap();
				WebSocketSession wsSession = wsSessionMap.get((String)session.getAttribute("Email"));
				
				if(wsSession != null) {
					TextMessage textMessage = new TextMessage("likeThumb," + likeNoti.getThumbing_user() + "," + likeNoti.getThumbed_user() 
					+ "," + likeNoti.getB_number() + "," + likeNoti.getB_subject());
					notificationHandler.handleMessage(wsSession, textMessage);
				} 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}
