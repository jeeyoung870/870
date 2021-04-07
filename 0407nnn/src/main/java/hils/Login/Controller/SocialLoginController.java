package hils.Login.Controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;

import hils.Login.Service.SocialLoginService;

@Controller
public class SocialLoginController {

	/* NaverLoginBO */
	private NLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// 네이버 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "SocialLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		// 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		System.out.println("네이버:" + naverAuthUrl);

		// 네이버 URL 저장
		model.addAttribute("naver_url", naverAuthUrl);

		// 생성한 인증 URL을 View로 전달
		return "user/socialLogin";
	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "NmainPass", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		System.out.println("네이버 로그인 성공");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);
		model.addAttribute("result", apiResult);

		// 네이버 로그인 성공 페이지 View 호출
		return "user/mainPass";
	}

//==============================================================================
	// 구글 로그인 시 이메일 정보 세션과 DB에 저장

	@Autowired
	private SocialLoginService socialLoginService;

	public SocialLoginService getSocialLoginService() {
		return socialLoginService;
	}

	public void setSocialLoginService(SocialLoginService socialLoginService) {
		this.socialLoginService = socialLoginService;
	}

	@RequestMapping(value = "email")
	public void email2(HttpServletRequest request, String user_email) throws Exception  {
		// sessionStorage 값 session 에 저장
		HttpSession session = request.getSession();
		session.setAttribute("Email", user_email);
		String se = (String) session.getAttribute("Email");
		System.out.println(se);
		
		int result = socialLoginService.idCheckSocial(user_email);
		try {
			if(result == 0) {
				// 아이디가 중복이 아니라면 그대로 DB에 등록
				System.out.println("아이디 등록 시작");
				socialLoginService.email(user_email);
				socialLoginService.email2(user_email);
			}else if(result == 1) {
				// 아이디가 중복이라면 이미 등록은 되어있으므로 등록은 생략
				System.out.println("아이디 등록 미실행");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//==============================================================================

	// 로그아웃
	@RequestMapping(value = "socialLogoutsuccess", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) throws Exception {
		session.invalidate(); // 세션 무효화 해서 로그아웃.
		// return "redirect:/경로"; 얼럿창출력안하고 바로 지정 페이지로 이동할 때 사용
		return "user/logoutsuccess";
	}
}