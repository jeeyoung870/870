package hils.Login.Controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hils.Login.Service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService = new LoginService();

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
	@RequestMapping(value = "logoutsuccess", method = RequestMethod.GET)
	public String logoutform() {

		/* View 정보를 반환하는 부분 */
		return "user/logoutsuccess"; // "/WEB-INF/views/user/loginform.jsp"
	}

	// 일반 로그인 성공
	@RequestMapping(value = "loginsuccess", method = RequestMethod.GET)
	public String loginresult(HttpServletRequest request, Principal principal) {
		HttpSession session = request.getSession();
		session.setAttribute("Email", principal.getName());
		String user_id = principal.getName();

		// 유저 로그인 날짜 받아오기, 로그인시 update 문으로 마지막 로그인 날짜만 업데이트 해주면 될듯
		System.out.println("마지막 로그인 저장 시작");
		loginService.lastLoginUpdate(user_id);
		System.out.println("마지막 로그인 저장 완료");

		return "user/loginsuccess";// "/WEB-INF/views/user/loginform.jsp"
	}

}
