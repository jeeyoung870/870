package hils.notification.websocket;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.plugin.Intercepts;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


public class NotificationInterceptor extends HttpSessionHandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		// TODO Auto-generated method stub
		ServletServerHttpRequest ssReq = (ServletServerHttpRequest)request;
		HttpServletRequest hReq = ssReq.getServletRequest();
		
		String id = (String)hReq.getSession().getAttribute("Email");
		if(id != null) {
			attributes.put("noti_user_id", id);
		}
		
		
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}
	
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		// TODO Auto-generated method stub
		super.afterHandshake(request, response, wsHandler, ex);
	}

}
