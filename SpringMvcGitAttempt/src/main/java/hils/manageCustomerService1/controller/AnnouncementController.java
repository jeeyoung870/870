package hils.manageCustomerService1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import hils.community.model.BoardPaging;
import hils.manageCustomerService1.model.AnnouncementDto;
import hils.manageCustomerService1.service.IAnnouncementService;

@Controller
public class AnnouncementController {
	
	@Autowired
	@Qualifier("announcementService")
	private IAnnouncementService iAnnouncementService;
	
	public AnnouncementController() {};
	
	public AnnouncementController(IAnnouncementService iAnnouncementService) {
		this.iAnnouncementService = iAnnouncementService;
	}
	@RequestMapping("goToWriteNewAnnouncement")
	public String writeNewAnnouncement() {
		
		return "manageCustomerService1/newAnnounceForm";
	}
	@RequestMapping("goToAnnouncement")
	public ModelAndView goToAnnouncement() {
		int annouCount = iAnnouncementService.countTotalAnnouService();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manageCustomerService1/manageAnnounceBoard");
		mav.addObject("annouCount", annouCount);
		return mav;
	}
	@RequestMapping(value = "searchAnnou", produces ="application/text;charset=utf-8")
	@ResponseBody
	public String doAnnouSearch(String searchOption, String searchKeyword, Model model) {
		List<AnnouncementDto> annouList = iAnnouncementService.searchAnnouService(searchKeyword, searchOption);
		model.addAttribute("annouList", annouList);

		Gson json = new Gson();
		
		return json.toJson(model);
	}
	@RequestMapping("writeNewAnnouncement")
	public String writeNewAnnouncement(HttpServletRequest request, String subject, String content) {
		HttpSession session = request.getSession();
		//Announcement must be written by manager, only manager, no more no less
		AnnouncementDto announcementDto = new AnnouncementDto();
		announcementDto.setSubject(subject);
		announcementDto.setContent(content);
		announcementDto.setUser_id((String)session.getAttribute("Email"));
		
		iAnnouncementService.newAnnouncementService(announcementDto);
		return "redirect:./goToAnnouncement";
	}
	@RequestMapping("goToUpdateAnnou")
	public ModelAndView goToUpdateAnnou(int annou_writing_num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("annou", iAnnouncementService.selectAnnouService(annou_writing_num));
		mav.setViewName("manageCustomerService1/updateAnnounceContentForm");
		return mav;
	}
	@RequestMapping("deleteAnnou")
	public String deleteAnnou(int annou_writing_num) {
		iAnnouncementService.deleteAnnou(annou_writing_num);
		return "redirect:./goToAnnouncement";
	}
	@RequestMapping("updateAnnou")
	public String updateAnnou(String subject, String content, int annou_writing_num) {
		iAnnouncementService.updateAnnou(subject, content, annou_writing_num);
		
		return "redirect:./goToAnnouncement";
	}
	@RequestMapping("manageSpecificAnnou")
	public ModelAndView manageSpecificAnnou(int annou_writing_num) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("annou", iAnnouncementService.selectAnnouService(annou_writing_num));
		mav.setViewName("manageCustomerService1/annouContent");
		return mav;
	}
	///////////////user
	@RequestMapping("/userAnnouBoard")
	public ModelAndView userAnnouBoard	(@RequestParam(defaultValue = "10")int per, @RequestParam(defaultValue = "1")int requestPage) {
		int start = (requestPage - 1) * per + 1;
		int end = requestPage * per;
		
		List<AnnouncementDto> annouList = iAnnouncementService.userAnnouListService(start, end);
		BoardPaging annouPaging = new BoardPaging();
		annouPaging.setPer(per);
		
		int totalAnnouCount = iAnnouncementService.countTotalAnnouService();
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("community/userAnnouBoard");
		mav.addObject("annouPaging", annouPaging.doPageCalculate(requestPage, totalAnnouCount));
		mav.addObject("annouList", annouList);
		return mav;
	}
	
}
