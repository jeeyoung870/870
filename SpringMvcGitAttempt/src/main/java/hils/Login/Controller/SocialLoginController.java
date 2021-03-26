package hils.Login.Controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;

import hils.Login.Model.MemberDto;
import hils.Login.Service.SocialLoginService;

@Controller
@RequestMapping("/login")
public class SocialLoginController {

	/* NaverLoginBO */
	private NLoginBO naverLoginBO;  
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// 네이버 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/SocialLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		System.out.println("네이버:" + naverAuthUrl);

		// 네이버
		model.addAttribute("naver_url", naverAuthUrl);

		/* 생성한 인증 URL을 View로 전달 */
		return "user/socialLogin";
	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/NmainPass", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		System.out.println("네이버 로그인 성공");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);
		model.addAttribute("result", apiResult);

		/* 네이버 로그인 성공 페이지 View 호출 */
		return "user/mainPass";
	}

//==============================================================================
	@Autowired
	private SocialLoginService socialLoginService;
	
	
	public SocialLoginService getSocialLoginService() {
		return socialLoginService;
	}

	public void setSocialLoginService(SocialLoginService socialLoginService) {
		this.socialLoginService = socialLoginService;
	}

	// 구글 로그인 후 DB에 유저 정보 전송
	@RequestMapping(value = "/insertDB")
	public void data(@RequestParam Map<String, Object> param, HttpServletRequest request, MemberDto MemberDto) {
		System.out.println("param::"+param);
		socialLoginService.method(param);
	}

//==============================================================================

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) throws Exception {
		session.invalidate(); // 세션 무효화 해서 로그아웃.
		// return "redirect:/경로"; 얼럿창출력안하고 바로 지정 페이지로 이동할 때 사용
		return "user/logout";
	}
}