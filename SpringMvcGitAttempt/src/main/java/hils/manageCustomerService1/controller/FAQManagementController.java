package hils.manageCustomerService1.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hils.manageCustomerService1.model.FAQManagementDto;
import hils.manageCustomerService1.model.FAQManagementListModel;
import hils.manageCustomerService1.service.FAQManagementService;

@Controller
public class FAQManagementController{

	/*
	 * faqRegistration: faq 등록
	 * faqModify: 수정
	 * faqDelete: 삭제
	 * faqSerch: 검색
	 * */
	@Autowired
	FAQManagementService service;
	
	@RequestMapping("faqmanageboard")
	public String saqManagementBoard(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "per", defaultValue = "10") int per,
			String category,
			String searchWord, 
			Model m) {
		FAQManagementListModel list = service.faqManageSearchBoardlist(pageNum, per, category, searchWord);
		m.addAttribute("list",list);
		int number = list.getCount() - (pageNum - 1) * per;
		m.addAttribute("number",number);
		m.addAttribute("pageNum",pageNum);
		return "managecustomerservice1/faqmanageboard";
	}

	// content
	@GetMapping("faqContent")
	public String faqContent(@RequestParam(value="p")int pageNum, int num, Model m) {
		FAQManagementDto dto = service.getContent(num);
		m.addAttribute("article",dto);
		m.addAttribute("pageNum",pageNum);
		return "managecustomerservice1/faqContent";
	}
	
	// writeForm
	@GetMapping("faqRegistration")
	public String faqRegistration(@ModelAttribute("dto") FAQManagementDto dto) {
		return "managecustomerservice1/faqRegistration";
	}
	
	//관리자페이지 - FAQ 글쓰기 등록 메소드 faqManageBoardWrite 실행
	@PostMapping("faqManageBoardWrite")
	public String write(FAQManagementDto dto) {
		System.out.println("category"+dto.getCategory());
		service.insert(dto);
		return "redirect:faqmanageboard";
	}
	
	
	
	// faqUpdateForm에서 글을 작성하면 게시판목록으로 이동
	@GetMapping("faqUpdateForm")
	public String faqUpdateForm(int num, int p, Model m) {
		FAQManagementDto dto = service.updateForm(num);
		m.addAttribute("article", dto);
		m.addAttribute("pageNum",p);
		return "managecustomerservice1/faqupdateform";
	}
	// put방식 list
	// 수정폼에서의 글쓰기
	@PutMapping("faqManageBoard")
	public String faqUpdate(FAQManagementDto dto, HttpServletRequest request) {
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("한글 출력");
			System.out.println("수정 한글 테스트" + dto.getNum()+dto.getContent()+dto.getCategory());
			service.update(dto);
			return "redirect:faqmanageboard";
	}
	
	@GetMapping("faqDeleteForm")
	public String faqDelete(int num) {
		service.delete(num);
		return "redirect:faqmanageboard";
	}

	public void setService(FAQManagementService service) {
		this.service = service;
	}
	
}
