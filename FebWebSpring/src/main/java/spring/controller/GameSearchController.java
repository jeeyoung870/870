package spring.controller;

import java.util.ArrayList;
import java.util.List;

import spring.service.SearchCommand;
import spring.service.SearchResult;
import spring.service.SearchService;
import spring.model.SearchType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller    //controller클래스로 등록됨
public class GameSearchController {
	@Autowired
	private SearchService searchService;

	//@ModelAttribute : @RequestMapping전에 동작함.
	//GameSearchController요청이 들어올때마다 항상 실행됨.
	@ModelAttribute("searchTypeList")  
	public List<SearchType> referenceSearchTypeList() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체")); //(값, 화면에 보여질 내용)
		options.add(new SearchType(2, "뉴스"));
		options.add(new SearchType(3, "블로그"));
		return options;  //model이 되어 view에 전달된다.
	}

	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryList() {
		return new String[] { "게임", "웹툰", "뷰티" };
	}

	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";	//viewResolver로 넘겨주는 viewname
	}

	@RequestMapping("/search/game.do")
	//form에서 입력받은 값을command객체에 저장 (type의 값)
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
		//ModelAndView생성자 첫번째 매개변수는 view name
		ModelAndView mav = new ModelAndView("search/game");
		System.out.println("검색어 = " + command.getQuery().toUpperCase());
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult", result);
		return mav;	//dispatcher-servlet으로 전달
	}

	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex) {
		return "error/nullException";
	}
	
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

}