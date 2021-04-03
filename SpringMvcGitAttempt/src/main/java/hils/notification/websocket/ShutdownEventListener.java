//package hils.notification.websocket;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextClosedEvent;
//
//public class ShutdownEventListener implements ApplicationListener<ContextClosedEvent> {
//
//	@Autowired
//	@Qualifier("notificationHandler")
//	private NotificationHandler notificationHandler;
//	
//	public void setNotificationHandler(NotificationHandler notificationHandler) {
//		this.notificationHandler = notificationHandler;
//	}
//	@Override
//	public void onApplicationEvent(ContextClosedEvent event) {
//		// TODO Auto-generated method stub
//		System.out.println("ShutdownEventListener");
//		notificationHandler.terminateGracefully();
//	}
//
//}
	