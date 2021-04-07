package spring.controller;

import javax.servlet.http.HttpServletRequest;

import spring.model.Address; 
import spring.model.MemberInfo;
import spring.validator.MemberInfoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account/create.do")
public class CreateAccountController {

	@ModelAttribute("command")	//Mapping메소드 이전에 항상 실행
	public MemberInfo formBacking(HttpServletRequest request) {
		//getMethod : get/post인지 가져옴
		if (request.getMethod().equalsIgnoreCase("GET")) {
			MemberInfo mi = new MemberInfo();
			Address address = new Address();
			//getRemoteAddr : 접속한 클라이언트의 ip가져옴
			address.setZipcode(autoDetectZipcode(request.getRemoteAddr()));
			mi.setAddress(address);
			return mi;	//command라는 이름으로 modeldata에 추가
		} else {
			return new MemberInfo();
		}
	}

	private String autoDetectZipcode(String remoteAddr) {
		return "00000";
	}

	@GetMapping
	public String form() {
		return "account/creationForm";	//command객체와 함께 viewResolver로 전달됨
	}

	//post로 요청(폼 제출받았을때 실행됨)
	@RequestMapping(method = RequestMethod.POST)
	//command로 넘어온 파라미터값 저장
	public String submit(@ModelAttribute("command") MemberInfo memberInfo, BindingResult result) {
		new MemberInfoValidator().validate(memberInfo, result);
		if (result.hasErrors()) {
			//BindingResult객체에 에러메시지가 있다면,
			return "account/creationForm";
		}//에러없으면,(칸 다채웠으면)
		return "account/created";
	}
	
	
	
}