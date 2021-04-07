package spring.controller;

import javax.validation.Valid;

import spring.service.AuthenticationException;
import spring.service.Authenticator;
import spring.service.LoginCommand;
import spring.validator.LoginCommandValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login.do")		//get/post별로 다른 메소드를 사용, 공통 url
public class LoginController {

	private String formViewName = "login/form";
	
	@Autowired
	private Authenticator authenticator;

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}

	//반환객체가 loginCommand 객체로 전달됨(LoginCommand앞글자만 소문자로 바꾼 이름)
	@ModelAttribute
	public LoginCommand formBacking() {
		return new LoginCommand();  //id 와 pw가 null값, 혹은 입력된 상태인 model객체가 전달됨
	}

	@RequestMapping(method = RequestMethod.POST)
	//@Valid : 어떤 ﻿Validator를 사용할건지 initBinder어노테이션메서드로 지정
	//loginCommand : @ModelAttribute에서 반환한 객체가 파라미터에 데이터를 담아 인자로 들어온것
	public String submit(@Valid LoginCommand loginCommand, BindingResult result) {
		if (result.hasErrors()) {
			return formViewName;
		}
		try {
			authenticator.authenticate(loginCommand);
			return "redirect:/index.jsp";
		//돌아오는 예외객체가 있다면 처리
		} catch (AuthenticationException e) {
			//reject : global에러를 발생시키는 메소드
			//Object[] { loginCommand.getUserId() } : 에러메시지의 {0}템플릿 안에 들어갈 텍스트/ null: 값 못찾을시 디폴트텍스트
			result.reject("invalidIdOrPassword", new Object[] { loginCommand.getUserId() }, null);
			return formViewName;
		}
	}

	//초기화 어노테이션. @ModelAttribute보다 먼저 수행된다.
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//LoginCommandValidator클래스는 꼭 Validator클래스를 구현하고 있어야 한다.
		binder.setValidator(new LoginCommandValidator());
		//지전된 클래스 안의 validate()메소드가 자동실행
	}

	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;
	}
}