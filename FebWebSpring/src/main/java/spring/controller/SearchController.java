package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

	@RequestMapping("/search/internal.do")
	public ModelAndView searchInternal(
		String query,@RequestParam("p") int pageNumber) {
		System.out.println("query=" + query + ",pageNumber=" + pageNumber);
		//모델앤뷰객체 ModelAndView("viewname") / ﻿("viewname", Map) / ﻿("viewname", "ModelName", ModelData)
		//첫번짜 매개변수는 뷰이름이다.
		return new ModelAndView("search/internal");
	}

	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(String query,
			@RequestParam(value = "p", defaultValue = "1") int pageNumber) {
		System.out.println("query=" + query + ",pageNumber=" + pageNumber);
		return new ModelAndView("search/external");
	}
}