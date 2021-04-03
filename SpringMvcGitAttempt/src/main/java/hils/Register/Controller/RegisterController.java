package hils.Register.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hils.Register.Model.RegisterDto;
import hils.Register.Service.RegisterService;

@Controller
@RequestMapping("user")
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private RegisterService service;

	public RegisterService getService() {
		return service;
	}

	public void setService(RegisterService service) {
		this.service = service;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {
		logger.info("get register");
	}

	// 회원가입 post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(RegisterDto regiDto) throws Exception {
		logger.info("post register");
		int result = service.idCheck(regiDto);
		System.out.println("체크결과(1=중복, 0=가능) :"+result);
		// 중복 값이 1이라면 이미 있는 아이디므로 다시 회원가입창으로 돌아가고
		try {
			if(result == 1) {
				System.out.println("아이디 중복 다시 회원가입창 불러옴");
				return "user/registerFail";
			// 0이라면 그대로 진행
			}else if(result == 0) {
				System.out.println("아이디 가능 회원가입 절차 진행");
				service.register(regiDto);
				service.register2(regiDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("가입 절차 완료 로그인 페이지로 이동");
		// 실행이 완료되면 로그인 페이지로 돌아감
		return "user/registersuccess";
	}
	
	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value="/idCheck", method = {RequestMethod.POST, RequestMethod.GET})
	public int idCheck(RegisterDto regiDto) throws Exception {
		int idResult = service.idCheck(regiDto);
		return idResult;
	}
	
	// 이메일 중복 체크
	@ResponseBody
	@RequestMapping(value="/emailCheck", method = {RequestMethod.POST, RequestMethod.GET})
	public int emailCheck(RegisterDto regiDto) throws Exception {
		int emailResult = service.emailCheck(regiDto);
		return emailResult;
	}
}