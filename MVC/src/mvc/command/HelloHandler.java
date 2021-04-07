package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHandler implements CommandHandler {
//view의 역할>>
//1. 비지니스 로직
//2. 화면에 보여질 결과물 저장(request, response)
//3. 
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("hello", "안녕하세요!"); //view에서 보여줄 데이터
		return "/view/hello.jsp"; 
	}

}
