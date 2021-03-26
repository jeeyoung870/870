package hils.notification.websocket;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Aspect
@Component("notificationAspect")
public class NotificationAspect {
	
	@Autowired
	private NotificationHandler notificationHandler;
	
	public void setNotificationHandler(NotificationHandler notificationHandler) {
		this.notificationHandler = notificationHandler;
	}

	public Object doNoti(JoinPoint joinpoint, Object returnValue) throws Throwable {
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		for ( Object o : joinpoint.getArgs()){
            if ( o instanceof HttpServletRequest ) {
                request = (HttpServletRequest)o;
            }
            if ( o instanceof HttpServletResponse ) {
                response = (HttpServletResponse)o;
            }
        }//joinpoint�� �ش� �޼ҵ�, joinpoint.getArgs()�� �ش� �޼ҵ��� �Ķ���͸� �����´�. ���� �ش� �޼ҵ忡 httpServletRequestȤ�� httpServletResponse�� �����Ͽ��� �Ѵ�.
        try{
            HttpSession session = request.getSession();

			List<WebSocketSession> wsSessionList = notificationHandler.getSessionList();
			for (WebSocketSession wsSess : wsSessionList) {
				try {	
					wsSess.sendMessage(new TextMessage("hello!"));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
        }catch(Exception e){
        	
        }

		return returnValue;
	}
}
