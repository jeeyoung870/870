package hils.mainpage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hils.mainpage.service.MainPageService;

@Controller
public class MainPageController {
	
	@RequestMapping("main")
	public String showMainPage() {
		return "mainPage";
	}

}
