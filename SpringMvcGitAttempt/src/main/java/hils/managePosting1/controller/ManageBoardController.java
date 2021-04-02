package hils.managePosting1.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import hils.community.model.BoardDto;
import hils.managePosting1.model.ManagerSearchVO;
import hils.managePosting1.service.IManageBoardService;

@Controller
public class ManageBoardController {

	@Autowired
	@Qualifier("manageBoardService")
	private IManageBoardService iManageBoardService;
	public ManageBoardController() {}
	public ManageBoardController(IManageBoardService iManageBoardService) {
		this.iManageBoardService = iManageBoardService;
	}
	@RequestMapping("goToManageBoard")
	public String goToManageBoard() {
		return "managePosting/manageBoard";
	}

	@RequestMapping("searchArticleManager")
	@ResponseBody
	public String searchArticleManager(ManagerSearchVO managerSearchVO, Model model) {
		//Date start_date = null;
		//Date end_date = null;
		/*
		 * try { start_date = new
		 * SimpleDateFormat("yyyy-MM-dd").parse(managerSearchVO.getPrepro_start_date());
		 * end_date = new
		 * SimpleDateFormat("yyyy-MM-dd").parse(managerSearchVO.getPrepro_end_date()); }
		 * catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		//managerSearchVO.setStart_date(start_date);
		//managerSearchVO.setEnd_date(end_date);
		List<BoardDto> searchBoardList = iManageBoardService.managerSearchBoardService(managerSearchVO);
		model.addAttribute("searchResultList", searchBoardList);
		Gson json = new Gson();
		return json.toJson(model);
	}
	@RequestMapping("managerDeleteArticle")
	public String managerDeleteArticle(int b_number) {
		iManageBoardService.doManagerDeleteArticle(b_number);
		
		return "redirect:goToManageBoard";
	}
	@RequestMapping("goToManagerUpdateArticle")
	public ModelAndView goToUpdateManagerArticle(int b_number) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", iManageBoardService.getBoardContent(b_number)); 
		mav.setViewName("managePosting/manageUpdateArticle");
		return mav;
	}
	@RequestMapping("managerUpdateArticle")
	public String managerUpdateArticle(int b_number, String subject, String content) {
		BoardDto boardDto = new BoardDto();
		boardDto.setB_content(content);
		boardDto.setB_number(b_number);
		boardDto.setB_subject(subject);
		iManageBoardService.doManagerUpdateArticleService(boardDto);
		
		return "redirect:goToManageBoard";
	}
}
