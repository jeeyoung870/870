package spring.interceptor;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
		
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
		
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//인터셉터 클래스.(preHandle()은 HandlerInterceptorAdapter인터페이스에서 오버라이딩.)
public class EventExpirationCheckInterceptor extends HandlerInterceptorAdapter {
		
	//preHandle : 요청전달 전에 수행
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (checkEvent(request) && checkEventExpiration()) {
			displayEventExpirationPage(request, response);	//"eventExpired.do"로 리다이렉트(이벤트종료화면을 클라이언트에 전달)
			return false;		//preHandle리턴값이 false일경우 그대로 요청 종료. 그래도 response는 넘어감
		}
		return true;	//다음작업이 계속됨 EventController의 list()메소드로 넘어감
	}
		
	private boolean checkEvent(HttpServletRequest request) {
		return request.getRequestURI().equals(
				request.getContextPath() + "/event/list.do");
	}
		
	//이벤트 날짜가 만료되었는지 아닌지 확인하는 메소드
	private boolean checkEventExpiration() {
		Calendar calendar = Calendar.getInstance();
		//이벤트 종료 날짜. Calendar의 month는 0부터 시작하기 때문에, 9월 9일이다.
		calendar.set(2021, 8, 9);	
		Date now = new Date();	//오늘날짜
		//now가 전달받은 날짜보다 오늘이 뒤인지 체크. 뒤라면 true 리턴
		return now.after(calendar.getTime());
	}
		
	private void displayEventExpirationPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.sendRedirect("eventExpired.do");
	}
		
}