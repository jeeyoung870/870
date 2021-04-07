package hils.customerService.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hils.customerService.model.AskAndReplyDto;
import hils.customerService.model.AskDto;
import hils.customerService.model.WriteOneOneVO;
import hils.customerService.service.OneOneDao;
import hils.customerService.service.OneOneService;
import hils.customerService.validator.OneVOneValidator;

@Controller
public class CustomerServiceController {

	@Autowired
	private OneOneService oneOneService;

	@Autowired
	private OneVOneValidator oneVOneValidator;
	
	public void setOneOneService(OneOneService oneOneService) {
		this.oneOneService = oneOneService;
	}
	@RequestMapping("goOneOneForm")
	public String goOneOneForm(@ModelAttribute("writeOneOneVO") WriteOneOneVO writeOneOneVO) {
		return "customerService/oneOneForm";
	}
	@RequestMapping("goCheckOneOne")
	public String goCheckOneOne() {
		return "redirect:./checkOneOne";
	}
	
	@RequestMapping("doOneOne")
	public String doOneOneAsk(HttpServletRequest request, @ModelAttribute("writeOneOneVO") WriteOneOneVO writeOneOneVO, BindingResult bResult) {
		oneVOneValidator.validate(writeOneOneVO, bResult);
		
		if(bResult.hasErrors()) {
			return goOneOneForm(writeOneOneVO);
		}else {
			AskDto askDto = new AskDto();
			askDto.setAsk_content(writeOneOneVO.getTextToManager());
			askDto.setAsk_title(writeOneOneVO.getUserSubject());
			askDto.setIs_replied("N");
			
			HttpSession session = request.getSession();
			askDto.setUser_id((String)session.getAttribute("Email"));
			
			oneOneService.writeNewOneOneService(askDto);
			
			return "redirect:./checkOneOne";
		}
		
	}
	@RequestMapping("checkOneOne")
	public ModelAndView checkOneOne(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email");
		List<AskDto> askList = oneOneService.selectAskListService(user_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customerService/checkOneOne");
		mav.addObject("askList", askList);
		
		return mav;
	}
	@GetMapping("checkOneOneContent")
	public ModelAndView checkOneOneContent(HttpServletRequest request, int ask_num) {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email");
		AskAndReplyDto askAndReply = oneOneService.selectAskAndReplyService(user_id, ask_num);

		ModelAndView mav = new ModelAndView();
		mav.addObject("askAndReply", askAndReply);
		mav.setViewName("customerService/checkOneOneAnswer");
		return mav;
	}
}
