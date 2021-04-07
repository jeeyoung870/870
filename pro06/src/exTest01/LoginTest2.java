package exTest01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿으로 요청시 관리자 화면 나타내기

/**
 * Servlet implementation class LoginTest2
 */
@WebServlet("/loginTest2")
public class LoginTest2 extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init()  {
		System.out.println("init method call");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy method call");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("아이디 : "+id);
		System.out.println("비번 : "+pw);
		
		if ((id != null && (id.length() != 0)) && (pw != null && pw.length() != 0)){
			if (id.equals("admin")) {
				out.print("<html><body>");
				out.print("<font size='12'>관리자로 로그인하셨습니다! </font><br>");
				out.print("<input type='button' value='회원정보 수정하기'>");
				out.print("<input type='button' value='회원정보 삭재하기'>");
				out.print("</body></html>");
			}else {
				out.print("<html><body>");
				out.print(id + " 님! 로그인하셨습니다.<br>");
				out.print("</body></html>");
			}
		}else {
			out.print("<html><body>");
			out.print("입력정보가 부족합니다.<br>");
			out.print("<a href='http://localhost:8080/pro06/test01/login.html'>"
					+ "로그인창으로 이동</a>");
			out.print("</body></html>");
		}
		
	}

}
