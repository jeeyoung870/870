package view.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import view.model.LoginCommand;
import view.service.AuthenticationException;
import view.service.Authenticator;
import view.validator.LoginCommandValidator;

@Controller("loginController_view")
@RequestMapping("/login/login")
public class LoginController {
	
	@Autowired
	private Authenticator authenticator;

	@ModelAttribute("login")
	public LoginCommand formBacking() {
		return new LoginCommand(); //form을 위한 객체 생성
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "loginForm";  //뷰이름은 tiles설정파일의 definition name과 같은 이름이어야 함.
	}

	@RequestMapping(method = RequestMethod.POST)
	//form을 거쳐 정보를 담고 돌아오는 login객체
	public String submit(@ModelAttribute("login")LoginCommand loginCommand,
			BindingResult result) {
		new LoginCommandValidator().validate(loginCommand, result);
		if (result.hasErrors()) {
			return "loginForm";
		}
		try {
			authenticator.authenticate(loginCommand.getId(), loginCommand
					.getPassword());
			return "loginSuccess";
		} catch (AuthenticationException ex) {
			result.reject("invalidIdOrPassword", new Object[] { loginCommand
					.getId() }, null);
			return "loginForm";
		}
	}

	@ModelAttribute("loginTypes")
	protected List<String> referenceData() throws Exception {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

}