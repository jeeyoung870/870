package hils.community.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import hils.community.model.BoardDto;
import hils.community.model.BoardPaging;
import hils.community.model.SubBoardDto;
import hils.community.model.WriteArticleModel;
import hils.community.service.BoardService;
import hils.community.validator.BoardValidator;
import hils.notification.websocket.NotificationController;

@Controller
public class BoardController implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
	@Autowired
	private BoardValidator boardValidator;
	
	@Autowired
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
//	@RequestMapping("/goBoard")
//	public String boardForm() {
//		return "community/mainBoard";
//	}
	
	@RequestMapping("/showBoard")
	@ResponseBody
	public String showBoard(@RequestParam(defaultValue = "10")int per, @RequestParam(defaultValue = "1")int requestPage
			, @RequestParam(defaultValue = "general")String b_category, Model model) {
		
		System.out.println(b_category);
		int start = (requestPage - 1) * per + 1;
		int end = start * per;
//		int totalArticleCount = boardService.checkTotalArticleCountService();
		
		List<BoardDto> boardList = new ArrayList<>();
		if (b_category.equals("general")) {
			boardList = boardService.selectBoardListService(start, end, null);
		}else {
			boardList = boardService.selectBoardListService(start, end, b_category);
		}
		
		model.addAttribute("boardArticleList", boardList);
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setPer(per);
		
		//////////////////////////////////////////webscoket Testing
		
		System.out.println("successful Communication");
		Gson json = new Gson();
		return json.toJson(model);
	}
	
	@RequestMapping("/goBoard")
	public ModelAndView showBoardList(@RequestParam(defaultValue = "10")int per, @RequestParam(defaultValue = "1")int requestPage
									, @RequestParam(defaultValue = "general")String b_category
			) {
		ModelAndView mav = new ModelAndView();
		
		int start = (requestPage - 1) * per + 1;
		int end = start * per;
		int totalArticleCount = boardService.checkTotalArticleCountService();
		
		System.out.println(totalArticleCount);
		List<BoardDto> boardList = new ArrayList<>();
		if (b_category.equals("general")) {
			boardList = boardService.selectBoardListService(start, end, null);
		}else {
			boardList = boardService.selectBoardListService(start, end, b_category);
		}
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setPer(per);
		
		mav.addObject("boardArticleList", boardList);
		mav.addObject("boardPaging", boardPaging.doPageCalculate(requestPage, totalArticleCount));
		mav.setViewName("community/mainBoard");
//		System.out.println("successful control");
//		System.out.println(boardList);
		return mav;
	}
	
	@RequestMapping("/goToWriteForm")
	public String goToWriteForm(WriteArticleModel writeArticleModel) {

		return "community/boardWriteArticleForm";
	}
	
	@RequestMapping("/doWrite")
	public String doWrite(@ModelAttribute("writeArticleModel") @Valid WriteArticleModel writeArticleModel, BindingResult bResult) {
		boardValidator.validate(writeArticleModel, bResult);
		
		if(bResult.hasErrors()) {
			List<ObjectError> errorList = bResult.getAllErrors();
			
			return goToWriteForm(writeArticleModel);
		}else { 
			BoardDto boardDto = new BoardDto();
			boardDto.setB_subject(writeArticleModel.getB_subject());
			boardDto.setB_category(writeArticleModel.getCategory());
			boardDto.setB_content(writeArticleModel.getB_content());
			boardDto.setB_readcount(0);
			boardDto.setB_recommendcount(0);
			boardDto.setUser_id("empty");
			boardService.insertNewArticleService(boardDto);
			
			return "redirect:./goBoard";
		}
		
	}
	@RequestMapping("/showArticleContent")
	public ModelAndView showArticleContent(int b_number) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("specificContent", boardService.selectSpecificContentService(b_number));
		mav.addObject("subArticleList", boardService.selectSpecificSubBoardListService(b_number));	
		mav.setViewName("community/boardContents");
		return mav;
	}
	
	@RequestMapping("/writeSubArticle")
	public String writeComments(int b_number, String c_content) {
		SubBoardDto subBoardDto = new SubBoardDto();
		subBoardDto.setB_number(b_number);
		
		subBoardDto.setC_content(c_content);
		subBoardDto.setC_recocount(0);
		subBoardDto.setUser_id("dummy");
		subBoardDto.setC_number(boardService.selectCommentNumberService());
		
		boardService.insertNewCommentService(subBoardDto);
		return "redirect:./showArticleContent?b_number=" + b_number;
	}
	@RequestMapping("/goUpdateForm")
	public ModelAndView goUpdateForm(int b_number) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("specificContent" ,boardService.selectSpecificContentService(b_number));
		mav.setViewName("community/updateArticleForm");
		return mav;
	}
	@RequestMapping("/updateArticle")
	public String updateArticle(String b_subject, String b_content, int b_number) {
		boardService.updateArticleService(b_content, b_subject, b_number);
		
		return "redirect:./goBoard";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
}
