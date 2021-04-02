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
import org.springframework.web.bind.annotation.ResponseBody;

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

	// �꽕�씠踰� 濡쒓렇�씤 泥� �솕硫� �슂泥� 硫붿냼�뱶
	@RequestMapping(value = "/SocialLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		// �꽕�씠踰꾩븘�씠�뵒濡� �씤利� URL�쓣 �깮�꽦�븯湲� �쐞�븯�뿬 naverLoginBO�겢�옒�뒪�쓽 getAuthorizationUrl硫붿냼�뱶 �샇異�
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		System.out.println("�꽕�씠踰�:" + naverAuthUrl);

		// �꽕�씠踰� URL ���옣
		model.addAttribute("naver_url", naverAuthUrl);

		// �깮�꽦�븳 �씤利� URL�쓣 View濡� �쟾�떖
		return "user/socialLogin";
	}

	// �꽕�씠踰� 濡쒓렇�씤 �꽦怨듭떆 callback�샇異� 硫붿냼�뱶
	@RequestMapping(value = "/NmainPass", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		System.out.println("�꽕�씠踰� 濡쒓렇�씤 �꽦怨�");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 濡쒓렇�씤 �궗�슜�옄 �젙蹂대�� �씫�뼱�삩�떎.
		apiResult = naverLoginBO.getUserProfile(oauthToken);
		model.addAttribute("result", apiResult);

		// �꽕�씠踰� 濡쒓렇�씤 �꽦怨� �럹�씠吏� View �샇異�
		return "user/mainPass";
	}

//==============================================================================
	// 援ш� 濡쒓렇�씤 �떆 �씠硫붿씪 �젙蹂� �꽭�뀡怨� DB�뿉 ���옣
	
	@Autowired
	private SocialLoginService socialLoginService;

	public SocialLoginService getSocialLoginService() {
		return socialLoginService;
	}

	public void setSocialLoginService(SocialLoginService socialLoginService) {
		this.socialLoginService = socialLoginService;
	}

	@RequestMapping(value = "/email")
	public void email2(HttpServletRequest request, String email) {
		socialLoginService.email(email);
		
		// sessionStorage 媛� session �뿉 ���옣
		HttpSession session = request.getSession();
		session.setAttribute("Email", email);
		String se = (String) session.getAttribute("Email");
		System.out.println(se);
	}

//==============================================================================

	// 濡쒓렇�븘�썐	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) throws Exception {
		session.invalidate(); // �꽭�뀡 臾댄슚�솕 �빐�꽌 濡쒓렇�븘�썐.
		// return "redirect:/寃쎈줈"; �뼹�읉李쎌텧�젰�븞�븯怨� 諛붾줈 吏��젙 �럹�씠吏�濡� �씠�룞�븷 �븣 �궗�슜
		return "user/logout";
	}
}