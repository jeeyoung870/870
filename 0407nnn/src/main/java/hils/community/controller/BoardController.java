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

	//receive ajax request and send data, no need to return paging
	@RequestMapping("/showBoard")
	@ResponseBody
	public String showBoard(@RequestParam(defaultValue = "10")int per, @RequestParam(defaultValue = "1")int requestPage
			, @RequestParam(defaultValue = "general")String b_category, Model model) {
				
		int start = (requestPage - 1) * per + 1;
		int end = requestPage * per;
		int totalArticleCount = boardService.countCategoryService(b_category);
		String isCategory = "";
		List<BoardDto> boardList = new ArrayList<>();
		BoardPaging boardPaging = new BoardPaging();
		boardList = boardService.selectSpecificCategoryPreservedService(start, end, b_category);
		isCategory = "true";
		boardPaging.setPer(per);
		
		System.out.println(boardList);
		
		//computing and put row num in BoardDto. raw-rownum will be 1 - 10 even if it is at second page or third page and so on. 
		processRowNum(boardList, requestPage, per);
		
		model.addAttribute("boardArticleList", boardList);
		model.addAttribute("boardPaging", boardPaging.doPageCalculate(requestPage, totalArticleCount));
		model.addAttribute("isCategory", isCategory);
		Gson json = new Gson();
		return json.toJson(model);
	}
	
	//get "a href" request and send Model. need to return paging information
		@RequestMapping("/goBoard")
		public ModelAndView showBoardList(@RequestParam(defaultValue = "10")int per, @RequestParam(defaultValue = "1")int requestPage
										, @RequestParam(defaultValue = "default")String b_category
				) {
			
			
			int start = (requestPage - 1) * per + 1;
			int end = requestPage * per;
			int totalArticleCount = boardService.checkTotalArticleCountService();
			ModelAndView mav = new ModelAndView();
			List<BoardDto> boardList = new ArrayList<>();
			if (b_category.equals("default")) {
				boardList = boardService.selectBoardListService(start, end, null);
				mav.addObject("prev_b_category", "default");
			}else {
				boardList = boardService.selectBoardListService(start, end, b_category);
				totalArticleCount = boardService.countCategoryService(b_category);
				mav.addObject("prev_b_category", b_category);
			}
			
			processRowNum(boardList, requestPage, per);

			BoardPaging boardPaging = new BoardPaging();
			boardPaging.setPer(per);
			
			
			mav.addObject("boardArticleList", boardList);
			
			mav.addObject("boardPaging", boardPaging.doPageCalculate(requestPage, totalArticleCount));
			mav.setViewName("community/mainBoard");
			return mav;
		}
	
	
	//computing and put row num in BoardDto. raw-rownum will be 1 - 10 even if it is at second page or third page and so on.
	public void processRowNum(List<BoardDto> boardDtoList, int requestPage, int per ){
		int tempRowNum = 0;
		if((requestPage - 1) != 0) {
			for(BoardDto boardDto : boardDtoList) {
				tempRowNum = boardDto.getRownum();
				boardDto.setRownum(tempRowNum + (requestPage - 1) * per);
			}
		}
		//no need to return
	}
	@RequestMapping("deleteContent")
	@Transactional
	public String deleteCotent(int b_number) {
		boardService.deleteArticleService(b_number);
		boardService.deleteSubCommentService(b_number);
		
		return "redirect:./goBoard";
	}
	
	
	
	@RequestMapping("/goToWriteForm")
	public String goToWriteForm(WriteArticleModel writeArticleModel) {

		return "community/boardWriteArticleForm";
	}
	
	//At jsp side. There are restrictions to block non-imageFile  
	@RequestMapping("/doWrite")
	public String doWrite(HttpServletRequest request, @ModelAttribute("writeArticleModel") @Valid WriteArticleModel writeArticleModel, 
			@RequestParam("imageFile")MultipartFile imageFile ,BindingResult bResult) {
		//validate whether subject or content empty
		boardValidator.validate(writeArticleModel, bResult);
		HttpSession session = request.getSession();
		if(bResult.hasErrors()) {
			//if model have error. return it by calling goToWriteForm
			return goToWriteForm(writeArticleModel);
		}else { 
			//writeArticleModel and BoardDto are mismatched. because of b_readCount and b_recommendCount... 
			//can be resolved at DB(Default value)
			BoardDto boardDto = new BoardDto();
			boardDto.setB_subject(writeArticleModel.getB_subject());
			boardDto.setB_category(writeArticleModel.getCategory());
			boardDto.setB_content(writeArticleModel.getB_content());
			boardDto.setB_readcount(0);
			boardDto.setB_recommendcount(0);
			boardDto.setUser_id((String)session.getAttribute("Email"));
			
			///////handle file//////
			
			String url = fileHandler(imageFile);
			
			boardDto.setBoard_img_path(url);
			
			boardService.insertNewArticleService(boardDto);
			
			return "redirect:./goBoard";
		}
		
	}
	private String getId(HttpServletRequest request) {
		return (String)request.getSession().getAttribute("Email");
	}
	private String fileHandler(MultipartFile imageFile) {
		String originalFileName = imageFile.getOriginalFilename();
		String url = applicationContext.getServletContext().getRealPath("");
		url += "tempRepository\\";
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
		return url;
	}
	
	@RequestMapping("/showArticleContent")
	@Transactional
	public ModelAndView showArticleContent(HttpServletRequest request, int b_number) {
		String user_id = getId(request);
		//is thumbed, could use ENUM
		String result = boardService.isThumbService(b_number, user_id);
		if(result == null || result == "") {
			result = "N";
		}
		//is thumbed
		boardService.readcountUpService(b_number);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("specificContent", boardService.selectSpecificContentService(b_number));
		mav.addObject("subArticleList", boardService.selectSpecificSubBoardListService(b_number));	
		mav.addObject("isThumb", result);
		mav.setViewName("community/boardContents");
		return mav;
	}
	//Aspect will be applied, after-returning,  check NotificationAspect, check doNoti
	@RequestMapping(value = "/writeSubArticle", produces = "text/plain;charset=utf-8")
	@Transactional//data are locked until transaction is completed
	public String writeCommentsandSendNoti(HttpServletRequest request ,int b_number, String c_content) {
		HttpSession session = request.getSession(); 
		String user_id = (String)session.getAttribute("Email");
		//server Date Log
		Date serverTime = new Date();
		
		SubBoardDto subBoardDto = new SubBoardDto();
		
		subBoardDto.setB_number(b_number);
		subBoardDto.setC_content(c_content);
		subBoardDto.setC_recocount(0);
		subBoardDto.setUser_id(user_id);
		subBoardDto.setC_number(boardService.selectCommentNumberService());
		
		boardService.insertNewCommentService(subBoardDto);
		//noti, set CommentNotiDto in Session
		BoardDto specificArticle = boardService.selectSpecificContentService(b_number);
		CommentNotiDto commentNotiDto = new CommentNotiDto();
		commentNotiDto.setB_number(b_number);
		commentNotiDto.setReplyWriter(user_id);
		commentNotiDto.setBoardWriter(specificArticle.getUser_id());
		commentNotiDto.setComment_reg_date(serverTime);
		commentNotiDto.setB_subjet(specificArticle.getB_subject());
		session.setAttribute("commentNotiDto", commentNotiDto);
		
		//noti ends
	
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
	
	//Aspect will be applied, check NotificatoinAspect, doLikeNoti
	@RequestMapping(value = "/likeThumb", produces = "text/plain;charset=utf-8")
	@Transactional
	public String likeThumbAndSendNoti2(HttpServletRequest request, int b_number) {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email");
		
		//noti, set LikeNotiDto in Session. it will be extracted by NotificationAspect
		BoardDto specificLikeArticle = boardService.selectSpecificContentService(b_number);
		LikeNotiDto likeNoti = new LikeNotiDto();
		likeNoti.setB_number(b_number);
		likeNoti.setB_subject(specificLikeArticle.getB_subject());
		likeNoti.setThumbing_user(user_id);
		likeNoti.setThumbed_user(specificLikeArticle.getUser_id());
		session.setAttribute("likeNoti", likeNoti);
		
		//noti
		//count of thumb will be up
		boardService.thumbUpCountService(b_number);
		//new data(thumb information) will be stored at like_thumb table
		boardService.newLikeThumbService(b_number, user_id);
		return "redirect:./goBoard";
	}
	@RequestMapping("/cancelThumb")
	@Transactional
	public String cancelThumb(HttpServletRequest request, int b_number) {
		String user_id = getId(request);
		
		//cancel thumb
		boardService.cancelThumbService(b_number, user_id);
		boardService.thumbDownCountService(b_number);
		return "redirect:./goBoard";
	}
}

