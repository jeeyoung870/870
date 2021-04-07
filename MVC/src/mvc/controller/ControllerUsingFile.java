package mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

@WebServlet(urlPatterns = "/controllerUsingFile",
initParams = {@WebInitParam(name = "configFile", value = "/WEB-INF/commandHandler.properties")}) 
public class ControllerUsingFile extends HttpServlet {

	// <커맨드, 핸들러인스턴스> 매핑 정보 저장 > 객체 생성을 위해
	private Map commandHandlerMap = new java.util.HashMap();

	// web.xml에있는 param-value에 config를 받아서 String으로 받음
	// init() > 객체 생성하고 딱 한 번 실행
	//init()메소드는 공통사용임.
	public void init(ServletConfig config) throws ServletException {
		// 결론은 : web.xml > /WEB-INF/commandHandler.properties > prop객체로 옴김

		String configFile = config.getInitParameter("configFile"); //@WebInitParam으로 설정한 초기화 파라미터
		Properties prop = new Properties(); // 프로퍼티스 파일을 저장할 객체 생성(키, 값)으로 받으려고
		FileInputStream fis = null; // 파일로부터 내용을 읽어올 스트림 선언
		try {
			// 절대경로값을 String으로 받음
			String configFilePath = config.getServletContext().getRealPath(configFile);
                                                            // servlet config로부터 getServletContext() -> application 기본 객체
                                                           // application 까지의 경로(프로젝트) + 내가 지정한 경로
                                                            // 프로젝트까지의 경로(application) + /WEB-INF/commandHandler.properties
			fis = new FileInputStream(configFilePath);
			prop.load(fis);
			// 키와 값(클래스)가 짝지어서 저장(요청(키), 클래스(값))
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {
				}
		}

		// hello 키값 , hellohanlder 클래스의 객체를 Map에 담았다.
		Iterator keyIter = prop.keySet().iterator(); // key만 뽑아와서 꺼냄
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command); // 값(클래스)를 꺼내옴(문자열)
			try { // > 앞에서 꺼내온 것은 문자열이므로 클래스로 객체를 선언한 다음 사용
				Class handlerClass = Class.forName(handlerClassName); // 문자열로 받아와서 해당 이름의 클래스를 가져옴
				Object handlerInstance = handlerClass.newInstance(); // 사용하기 위해 해당 클래스의 객체 생성(process() 오버라이딩)
				commandHandlerMap.put(command, handlerInstance);
			} catch (ClassNotFoundException e) {
				throw new ServletException(e);
			} catch (InstantiationException e) {
				throw new ServletException(e);
			} catch (IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	} // 해당 요청이 들어올 때까지 대기

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

    // 실제로 일하는 메서드
	private void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("cmd");
		//키cmd로 전달된 값을 가져오기(핸들러이름)
		CommandHandler handler = (CommandHandler) commandHandlerMap.get(command);
		if (handler == null) {
			handler = new NullHandler();
		}
		String viewPage = null;
		try {
			viewPage = handler.process(request, response);
		} catch (Throwable e) {
			throw new ServletException(e);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}