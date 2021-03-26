package hils.customerservice2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import hils.customerservice2.model.FAQDto;
import hils.customerservice2.model.FAQListModel;
import hils.customerservice2.service.FAQService;
import hils.customerservice2.service.Paging;

@Controller
public class FAQController {
	
	@Autowired
	FAQService service;
	
	@RequestMapping("faqIntro")
	public String faqIntro() {
		return "customerService2/faqIntro";
	}
	
	/*@RequestMapping("faqView")
	public String faqView(@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "per", defaultValue = "10") int per, Model m) {
		FAQListModel list = service.faqViewList(pageNum, per);
		m.addAttribute("list",list);
		int number = list.getCount() - (pageNum - 1) * per;
		m.addAttribute("number",number);
		return "customerService2/faqPage";
	}*/
	
	@RequestMapping("faqViewCategory")
	public String faqViewCategory(
			@RequestParam(value = "p", defaultValue = "1") int requestPage,
			@RequestParam(value = "per", defaultValue = "10") int per,
			@RequestParam(defaultValue = "general") String category,
			Model m) {

		if(category.equals("1")) {
			category = "계정문제";
		} else if(category.equals("2")) {
			category = "커뮤니티";
		} else if(category.equals("3")) {
			category = "모바일";
		} else if(category.equals("4")) {
			category = "기능";
		} else if(category.equals("5")) {
			category = "통계";
		} else if(category.equals("6")) {
			category = "기타";
		} else {
			category="";
		}
		FAQListModel list = service.faqViewListCategory(requestPage, per, category);
		m.addAttribute("list",list);
		
		int number = list.getCount() - (requestPage - 1) * per;
		m.addAttribute("number",number);
		m.addAttribute("category",category);

		return "customerService2/faqViewListCategory";
	}
	
	/* ajax를 이용한 카테고리 분류 기능*/
	@RequestMapping(value="faqviewjson", produces ="application/text;charset=utf-8")
	@ResponseBody
	public String faqView(
			@RequestParam(value = "p", defaultValue = "1") int requestPage,
			@RequestParam(defaultValue = "general") String category,
			@RequestParam(value = "per", defaultValue = "10") int per,
			Model m) {
		int start = (requestPage - 1) * per + 1;
		int end = start * per;
		List<FAQDto> faqList = new ArrayList<>();
		faqList = service.selectFaqListService(start, end, category);
		
		m.addAttribute("faqList", faqList);
		m.addAttribute("category", category);
		/* 카테고리 분류시 카운트 where절 사용해서 가져오기.*/
		int count = service.getPagingCategory(category);
		/*ajax 페이징 출력*/
		FAQListModel list = service.faqViewListCategory(requestPage, per, category);
		m.addAttribute("list",list);
		
		/*paging*/
		Paging paging = new Paging();
		paging.setPer(per);
		m.addAttribute("pazing", paging.paging(requestPage, count, per));
		m.addAttribute("requestPage",requestPage);
		m.addAttribute("category",category);
		
		Gson json = new Gson();
		return json.toJson(m);
	}
	
	// content
	@GetMapping("faqViewContent")
	public String faqContent(
			@RequestParam(value="p")int pageNum, 
			int num, 
			Model m) {
		FAQDto dto = service.getContent(num);
		m.addAttribute("article",dto);
		m.addAttribute("pageNum",pageNum);
		
		return "customerService2/faqViewContent";
	}

	public void setService(FAQService service) {
		this.service = service;
	}
	
}
