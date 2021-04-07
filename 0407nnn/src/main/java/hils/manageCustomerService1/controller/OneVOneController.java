package hils.manageCustomerService1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hils.community.model.BoardDto;
import hils.community.model.BoardPaging;
import hils.customerService.model.AskDto;
import hils.customerService.model.ReplyDto;
import hils.customerService.service.OneOneDao;
import hils.customerService.service.OneOneService;
import hils.manageCustomerService1.model.AskAndReplyDto;
import hils.manageCustomerService1.service.IOneOneManageService;
import hils.notification.model.ReplyNotiDto;

@Controller
public class OneVOneController {
	
	@Autowired	
	@Qualifier("oneVOneManageService")
	private IOneOneManageService iOneOneManageService; // 
	
	@Autowired
	private OneOneService oneOneService;
	
	public void setOneOneService(OneOneService oneOneService) {
		this.oneOneService = oneOneService;
	}
	
	public OneVOneController() {};
	
	public OneVOneController(IOneOneManageService iOneOneManageService) {
		this.iOneOneManageService = iOneOneManageService;
	}
	
	@RequestMapping("goToOneVOneBoard")
	public String goToOneVOneBoard() {
		
		return "redirect:/manageCustomerService/showOneVOneBoard";
	}
	@RequestMapping("showOneVOneBoard")
	@Transactional
	public ModelAndView showOneVOneBoard(@RequestParam(defaultValue = "10")int per, @RequestParam(defaultValue = "1")int requestPage) {
		
		int start = (requestPage - 1) * per + 1;
		int end = requestPage * per;
		
		List<AskDto> askList = iOneOneManageService.getAskListService(start, end);
		
		//could be improved, useless object is created
		BoardPaging rawBoardPaging = new BoardPaging();
		rawBoardPaging.setPer(10);
		BoardPaging boardPaging = rawBoardPaging.doPageCalculate(requestPage, iOneOneManageService.getTotalAskCount());
		
		processRowNum(askList, requestPage, per);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("askList", askList);
		mav.addObject("boardPaging", boardPaging);
		mav.setViewName("manageCustomerService1/oneVOneBoard");
		
		return mav;
	}
	public void processRowNum(List<AskDto> askDtoList, int requestPage, int per ){
		int tempRowNum = 0;
		if(requestPage - 1 != 0) {
			for(AskDto askDto : askDtoList) {
				tempRowNum = askDto.getRownum();
				askDto.setRownum(tempRowNum + (requestPage - 1) * per);
			}
		}
		//there is no need to return value
	}
	@RequestMapping("showAskContent")
	public ModelAndView showAskContent(int ask_num) {
		
		AskAndReplyDto askAndReplyList = iOneOneManageService.getAskAndReplyService(ask_num);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("askAndReplyList", askAndReplyList);
		mav.setViewName("manageCustomerService1/manageOneVOneContent");
		return mav;
	}
	//Aspect will be applied.. check NotificationAspect, check doReplyNoti
	@RequestMapping("writeReply")
	@Transactional
	public String writeReplyandSendNoti(HttpServletRequest request, ReplyDto replyDto) {
		oneOneService.insertNewReply(replyDto);
		///noti, setReplyNoti in session, will be extracted at NotificationAspect
		HttpSession session = request.getSession();
		AskAndReplyDto specificOneOneData = iOneOneManageService.getAskAndReplyService(replyDto.getAsk_num());
		ReplyNotiDto replyNoti = new ReplyNotiDto();
		replyNoti.setAsk_subject(specificOneOneData.getAsk_title());
		replyNoti.setReply_date(specificOneOneData.getRep_date());
		replyNoti.setUser_id(specificOneOneData.getUser_id());
		
		session.setAttribute("replyNoti", replyNoti);
		///noti
		return "redirect:/manageCustomerService/showOneVOneBoard";
	}
}
