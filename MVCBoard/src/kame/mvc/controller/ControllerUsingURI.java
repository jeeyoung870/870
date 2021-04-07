package kame.mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class ControllerUsingURI extends HttpServlet {
   
    private HashMap commandMap = new HashMap();

    public void init(ServletConfig config) throws ServletException {
    	//propertyConfigr이름으로 넘어온 파라미터값을 가져온다
        String props = config.getInitParameter("propertyConfig");
        //properties파일(설정파일)의 경로
        Properties pr = new Properties();
        /*String path = config.getServletContext()
        			.getRealPath("webContent다음경로");*/
        FileInputStream f = null;
        try {
            f = new FileInputStream(props); 
            pr.load(f);
        } catch (IOException e) {
            throw new ServletException(e);
        } finally {
            if (f != null) try { f.close(); } catch(IOException ex) {}
        }
        //keySet()메소드로 키캆만 뽑아오기
        Iterator keyIter = pr.keySet().iterator();
        while( keyIter.hasNext() ) {
            String command = (String)keyIter.next();
            String className = pr.getProperty(command);
            try {
                Class commandClass = Class.forName(className);
                Object commandInstance = commandClass.newInstance();
                commandMap.put(command, commandInstance);
            } catch (ClassNotFoundException e) {
                throw new ServletException(e);
            } catch (InstantiationException e) {
                throw new ServletException(e);
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }

    public void doGet(
        HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        requestPro(request, response);
    }

    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        requestPro(request, response);
    }

    private void requestPro(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	String view = null;//view 정보
    CommandAction com=null;//model 객체
	try {
			//요청명령어에서 uri만 구하기
            String command = request.getRequestURI();
            //해당 문자열의 contextPath만 구하고 그 길이를 재서 그만큼만 잘라내고 나머지만 구한다(요청명 구하기)
            if (command.indexOf(request.getContextPath()) == 0) {
               command = command.substring(request.getContextPath().length());
            }
            //list.do로 요청한 경우 : 요청명령어와 짝지어진 listAction안의 객체 꺼내오기
            com = (CommandAction)commandMap.get(command); 
            //listActionㅇ안의 requestPro()메소드 실행
            view = com.requestPro(request, response);
        } catch(Throwable e) {
            throw new ServletException(e);
        }  
        RequestDispatcher dispatcher =request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}







