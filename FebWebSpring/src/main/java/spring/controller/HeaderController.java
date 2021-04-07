package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {

	@RequestMapping("/header/check.do")
	public String check
	(@RequestHeader("Accept-Language") String languageHeader) {
		System.out.println(languageHeader);
		return "header/pass";
	}
}