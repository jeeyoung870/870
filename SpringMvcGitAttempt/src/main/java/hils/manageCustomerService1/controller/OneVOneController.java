package hils.manageCustomerService1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hils.community.model.BoardPaging;
import hils.customerService.model.AskDto;
import hils.customerService.model.ReplyDto;
import hils.customerService.service.OneOneDao;
import hils.customerService.service.OneOneService;
import hils.manageCustomerService1.model.AskAndReplyDto;
import hils.manageCustomerService1.service.IOneVOneService;

@Controller
public class OneVOneController {
	
	@Autowired	
	@Qualifier("oneVOneService")
	private IOneVOneService iOneVOneService;
	
	@Autowired
	private OneOneService oneOneService;
	
	public void setOneOneService(OneOneService oneOneService) {
		this.oneOneService = oneOneService;
	}
	
	public OneVOneController() {};
	
	public OneVOneController(IOneVOneService iOneVOneService) {
		this.iOneVOneService = iOneVOneService;
	}
	
	@RequestMapping("goToOneVOneBoard")
	public String goToOneVOneBoard() {
		
		return "redirect:/manageCustomerService/showOneVOneBoard";
	}
	@RequestMapping("showOneVOneBoard")
	public ModelAndView showOneVOneBoard(@RequestParam(defaultValue = "10")int per, @RequestParam(defaultValue = "1")int requestPage) {
		
		int start = (requestPage - 1) * per + 1;
		int end = start * per;
		
		List<AskDto> askList = iOneVOneService.getAskListService(start, end);
		
		BoardPaging rawBoardPaging = new BoardPaging();
		rawBoardPaging.setPer(10);
		BoardPaging boardPaging = rawBoardPaging.doPageCalculate(requestPage, iOneVOneService.getTotalAskCount());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("askList", askList);
		mav.addObject("boardPaging", boardPaging);
		mav.setViewName("manageCustomerService1/oneVOneBoard");
		
		return mav;
	}
	@RequestMapping("showAskContent")
	public ModelAndView showAskContent(int ask_num) {
		
		AskAndReplyDto askAndReplyList = iOneVOneService.getAskAndReplyService(ask_num);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("askAndReplyList", askAndReplyList);
		mav.setViewName("manageCustomerService1/manageOneVOneContent");
		return mav;
	}
	@RequestMapping("writeReply")
	public String writeReply(ReplyDto replyDto) {
		oneOneService.insertNewReply(replyDto);
		return "redirect:/manageCustomerService/showOneVOneBoard";
	}
}
