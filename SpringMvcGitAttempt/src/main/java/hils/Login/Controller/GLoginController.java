package hils.Login.Controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login/G")
public class GLoginController {

	// 구글 로그인
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;

	// 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/Glogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		// 구글code 발행
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);

		System.out.println("구글 로그인창 주소:" + url);
		model.addAttribute("google_url", url);

		// 해당 view에 생성해서 추가해준 google_url 값을 전달해줌
		return "user/socialLogin";
	}

	// 로그인 성공 후 리다이렉트 뒷부분의 주소가 value 값이면 해당 메서드 실행해서 메인페이지 찾아감
	@RequestMapping(value = "/mainPass", method = { RequestMethod.GET, RequestMethod.POST })
	public String googleCallback(Model model, @RequestParam String code) throws IOException {
		System.out.println("구글 로그인 성공");

		return "user/mainPass";
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) throws Exception {
		// l.info("C: 로그아웃 GET");
		session.invalidate(); // 세션 무효화 해서 로그아웃.
		// return "redirect:/경로"; 얼럿창출력안하고 바로 지정 페이지로 이동할 때 사용
		return "login/logout";
	}
}