package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//GET방식으로 요청 처리
@Controller
public class FormController {
	@GetMapping(value = "/test/simpleTest.do", produces = "text/plain;charset=UTF-8")
	public String simpleTestForm() {
		return "test/simpleTestForm";
	}

	@RequestMapping(value = "/test/simpleTest1.do", method = RequestMethod.GET)
	public String simpleTestForm1() {
		return "test/simpleTestForm";
	}

	@RequestMapping(value = "/test/simpleTest2.do", method = RequestMethod.GET)
	public String simpleTestForm2() {
		return "test/simpleTestForm";
	}

}