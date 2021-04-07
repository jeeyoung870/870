package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("init 메소드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request : 톰캣 서버가 자동생성한 HttpServletRequest클래스의 객체
		request.setCharacterEncoding("utf-8");
		//한 개씩 전송된 값: getParameter()이용
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		//같은 name으로 여러 값 전송시 : getParameterValues() 이용(배열형태)
		System.out.println("아이디 : " + user_id);
		System.out.println("비밀번호 : " + user_pw);
		String [] subject = request.getParameterValues("subject");
		for (String str : subject) {
			System.out.println("선택과목 : " + str);
		}
	}

}




