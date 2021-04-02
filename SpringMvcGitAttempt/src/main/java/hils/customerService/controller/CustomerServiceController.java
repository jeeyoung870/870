package hils.customerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public String doOneOneAsk(@ModelAttribute("writeOneOneVO") WriteOneOneVO writeOneOneVO, BindingResult bResult) {
		oneVOneValidator.validate(writeOneOneVO, bResult);
		
		if(bResult.hasErrors()) {
			return goOneOneForm(writeOneOneVO);
		}else {
			AskDto askDto = new AskDto();
			askDto.setAsk_content(writeOneOneVO.getTextToManager());
			askDto.setAsk_title(writeOneOneVO.getUserSubject());
			askDto.setUser_id("dummy");
			askDto.setIs_replied("N");
			
			oneOneService.writeNewOneOneService(askDto);
			return "main";
		}
		
	}
	@RequestMapping("checkOneOne")
	public ModelAndView checkOneOne() {
		
		String user_id = "dummy";
		List<AskDto> askList = oneOneService.selectAskListService(user_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customerService/checkOneOne");
		mav.addObject("askList", askList);
		
		return mav;
	}
	@GetMapping("checkOneOneContent")
	public ModelAndView checkOneOneContent(int ask_num) {
		String user_id = "dummy";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("askAndReply", oneOneService.selectAskAndReplyService(user_id, ask_num));
		mav.setViewName("customerService/checkOneOneAnswer");
		return mav;
	}
}
