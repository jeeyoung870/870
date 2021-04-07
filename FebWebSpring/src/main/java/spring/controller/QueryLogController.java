package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.QueryLogCommand;

@Controller
public class QueryLogController {

	@ModelAttribute("command")
	public QueryLogCommand formBacking() {
		return new QueryLogCommand();		//model데이터로 추가
	}

	@RequestMapping("/log/query.do")
	//@ModelAttribute("command")  : 위 메소드에서 만들어진 QueryLogCommand객체
	//BindingResult : 값에 문제가 있을때 에러코드를 추가시켜주는 객체(validation.properties참조)
	public String query(@ModelAttribute("command") QueryLogCommand command,
			BindingResult result) {
		return "log/logList";  //viewname
	}
}