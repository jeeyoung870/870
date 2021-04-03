package hils.community.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import hils.community.model.BoardDto;
import hils.community.model.BoardPaging;
import hils.community.model.SubBoardDto;
import hils.community.model.WriteArticleModel;
import hils.community.service.BoardService;
import hils.community.validator.BoardValidator;
import hils.notification.model.CommentNotiDto;
import hils.notification.model.LikeNotiDto;
import hils.notification.websocket.NotificationController;

@Controller
public class BoardController implements ApplicationContextAware{
	
	private WebApplicationContext applicationContext;
	
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
		int end = requestPage * per;
//		int totalArticleCount = boardService.checkTotalArticleCountService();
		
		List<BoardDto> boardList = new ArrayList<>();
		if (b_category.equals("general")) {
			boardList = boardService.selectBoardListService(start, end, null);
		}else {
			boardList = boardService.selectBoardListService(start, end, b_category);
		}
		processRowNum(boardList, requestPage, per);
		
		model.addAttribute("boardArticleList", boardList);
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setPer(per);
		
		//////////////////////////////////////////webscoket Testing
		
		System.out.println("successful Communication");
		Gson json = new Gson();
		return json.toJson(model);
	}
	public void processRowNum(List<BoardDto> boardDtoList, int requestPage, int per ){
		int tempRowNum = 0;
		if(requestPage - 1 != 0) {
			for(BoardDto boardDto : boardDtoList) {
				tempRowNum = boardDto.getRownum();
				boardDto.setRownum(tempRowNum + (requestPage - 1) * per);
			}
		}
		//no need to return
	}
	
	
	@RequestMapping("/goBoard")
	public ModelAndView showBoardList(@RequestParam(defaultValue = "10")int per, @RequestParam(defaultValue = "1")int requestPage
									, @RequestParam(defaultValue = "general")String b_category
			) {
		ModelAndView mav = new ModelAndView();
		
		int start = (requestPage - 1) * per + 1;
		int end = requestPage * per;
		int totalArticleCount = boardService.checkTotalArticleCountService();
		
		System.out.println(totalArticleCount);
		List<BoardDto> boardList = new ArrayList<>();
		if (b_category.equals("general")) {
			boardList = boardService.selectBoardListService(start, end, null);
		}else {
			boardList = boardService.selectBoardListService(start, end, b_category);
		}
		
		processRowNum(boardList, requestPage, per);
		
		
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
	public String doWrite(HttpServletRequest request, @ModelAttribute("writeArticleModel") @Valid WriteArticleModel writeArticleModel, 
			@RequestParam("imageFile")MultipartFile imageFile ,BindingResult bResult) {
		boardValidator.validate(writeArticleModel, bResult);
		HttpSession session = request.getSession();
		
		System.out.println(bResult);
		if(bResult.hasErrors()) {
//			List<ObjectError> errorList = bResult.getAllErrors();
		
			return goToWriteForm(writeArticleModel);
		}else { 
			BoardDto boardDto = new BoardDto();
			boardDto.setB_subject(writeArticleModel.getB_subject());
			boardDto.setB_category(writeArticleModel.getCategory());
			boardDto.setB_content(writeArticleModel.getB_content());
			boardDto.setB_readcount(0);
			boardDto.setB_recommendcount(0);
			boardDto.setUser_id((String)session.getAttribute("Email"));
			
			///////handle file//////
			
			String originalFileName = imageFile.getOriginalFilename();
			String url = applicationContext.getServletContext().getRealPath("");
			url += "/tempRepository";
			File file = new File(url);
			file.mkdirs();
			url += originalFileName;
			file = new File(url);
			
			try {
				imageFile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			boardDto.setBoard_img_path(url);
			
			
			boardService.insertNewArticleService(boardDto);
			
			return "redirect:./goBoard";
		}
		
	}
	private String getId(HttpServletRequest request) {
		return (String)request.getSession().getAttribute("Email");
	}
	
	@RequestMapping("/showArticleContent")
	@Transactional
	public ModelAndView showArticleContent(HttpServletRequest request, int b_number) {
		String user_id = getId(request);
		//is thumb?
		String result = boardService.isThumbService(b_number, user_id);
		System.out.println("result :" + result);
		if(result == null || result == "") {
			result = "N";
		}
		//is thumb?
		boardService.readcountUpService(b_number);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("specificContent", boardService.selectSpecificContentService(b_number));
		mav.addObject("subArticleList", boardService.selectSpecificSubBoardListService(b_number));	
		mav.addObject("isThumb", result);
		mav.setViewName("community/boardContents");
		return mav;
	}
	
	@RequestMapping(value = "/writeSubArticle", produces = "text/plain;charset=utf-8")
	@Transactional//	the datas are locked until transaction is completed
	public String writeCommentsandSendNoti(HttpServletRequest request ,int b_number, String c_content) {
		HttpSession session = request.getSession(); 
		
		/////////////////////server Date Log
		Date serverTime = new Date();
		
		SubBoardDto subBoardDto = new SubBoardDto();
		subBoardDto.setB_number(b_number);
		
		subBoardDto.setC_content(c_content);
		subBoardDto.setC_recocount(0);
		String user_id = (String)session.getAttribute("Email");
		subBoardDto.setUser_id(user_id);
		subBoardDto.setC_number(boardService.selectCommentNumberService());
		//////////////noti////////////////
		BoardDto specificArticle = boardService.selectSpecificContentService(b_number);
		CommentNotiDto commentNotiDto = new CommentNotiDto();
		commentNotiDto.setB_number(b_number);
		commentNotiDto.setReplyWriter(user_id);
		commentNotiDto.setBoardWriter(specificArticle.getUser_id());
		commentNotiDto.setComment_reg_date(serverTime);
		commentNotiDto.setB_subjet(specificArticle.getB_subject());
		
		session.setAttribute("commentNotiDto", commentNotiDto);
		
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
		this.applicationContext = (WebApplicationContext)applicationContext;
	}
	@RequestMapping(value = "/likeThumb", produces = "text/plain;charset=utf-8")
	@Transactional
	public String likeThumbAndSendNoti2(HttpServletRequest request, int b_number) {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email");
		
		//noti
		BoardDto specificLikeArticle = boardService.selectSpecificContentService(b_number);
		LikeNotiDto likeNoti = new LikeNotiDto();
		likeNoti.setB_number(b_number);
		likeNoti.setB_subject(specificLikeArticle.getB_subject());
		likeNoti.setThumbing_user(user_id);
		likeNoti.setThumbed_user(specificLikeArticle.getUser_id());
		
		session.setAttribute("likeNoti", likeNoti);
		
		//noti
		boardService.thumbUpCountService(b_number);
		
		boardService.newLikeThumbService(b_number, user_id);
		return "redirect:./goBoard";
	}
	@RequestMapping("/cancelThumb")
	@Transactional
	public String cancelThumb(HttpServletRequest request, int b_number) {
		String user_id = getId(request);
		
		boardService.cancelThumbService(b_number, user_id);
		boardService.thumbDownCountService(b_number);
		return "redirect:./goBoard";
	}
}

