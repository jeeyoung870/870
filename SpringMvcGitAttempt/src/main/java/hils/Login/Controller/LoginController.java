package hils.Login.Controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	// 일반 로그인
	@RequestMapping(value = "loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginform() {
		System.out.println("loginform 메소드 호출입니다.");

		return "user/loginform";// "/WEB-INF/views/user/loginform.jsp"
	}

	// 일반 로그인실패 페이지 요청
	@RequestMapping(value = "loginfail", method = RequestMethod.GET)
	public String loginfail() {

		/* View 정보를 반환하는 부분 */
		return "user/loginfail"; // "/WEB-INF/views/user/loginform.jsp"
	}

	// 일반 로그아웃폼 페이지 요청
	@RequestMapping(value = "logoutform", method = RequestMethod.GET)
	public String logoutform() {

		/* View 정보를 반환하는 부분 */
		return "user/logout"; // "/WEB-INF/views/user/loginform.jsp"
	}

	// 일반 로그인 성공
	@RequestMapping(value = "loginsuccess", method = RequestMethod.GET)
	public String loginresult(HttpServletRequest request, Principal principal) {
		HttpSession session = request.getSession();
		session.setAttribute("Email", principal.getName());
		System.out.println(session.getAttribute("Email"));
		return "user/loginsuccess";// "/WEB-INF/views/user/loginform.jsp"
	}

}
