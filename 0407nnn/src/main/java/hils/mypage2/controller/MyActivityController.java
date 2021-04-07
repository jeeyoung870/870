package hils.mypage2.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import hils.Mypage1.controller.ProfileDto;
import hils.Mypage1.controller.SetProfileService;
import hils.mypage2.model.MyActBoardDto;
import hils.mypage2.model.MyActBoardListModel;
import hils.mypage2.model.MyActCalendarDto;
import hils.mypage2.model.MyActPaging;
import hils.mypage2.service.MyActBoardService;

@Controller
public class MyActivityController {
	
	@Autowired
	private MyActBoardService myActBoardService;
	
	@Autowired
	private SetProfileService  setProfileService ;
	
	/*내 힐린더*/
	@RequestMapping("myActivitySchedule")
	public ModelAndView goHilslinderCal(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email");;
		Date input_date = new Date();
		ModelAndView mav = new ModelAndView();
		
		List<MyActCalendarDto> hilsCalList = myActBoardService.getCalDataListService(user_id, input_date);
		
		List<String> calDataList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date tempDate = null;
		for(MyActCalendarDto dto : hilsCalList) {
			tempDate = dto.getWorkout_reg_date();
			calDataList.add(sdf.format(tempDate));
		}
		mav.setViewName("myActivitySchedule");
		mav.addObject("hlisCalList", hilsCalList);
		mav.addObject("calDataList", calDataList);
		System.out.println(hilsCalList);
		return mav;
	}
		
	/* 힐린더 날짜 변경 메소드*/
	@RequestMapping("myActCalChange")
	public ModelAndView goHilslinderCalChange(HttpServletRequest request, String year, String month) {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email");;
		
		String zeroDay = "01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date input_date = null;
		try {
			if(Integer.parseInt(month) < 10) {
				input_date = sdf.parse(year + "0" + month + zeroDay);
			}else {
				input_date = sdf.parse(year + month + zeroDay);
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
	
		List<MyActCalendarDto> hilsCalList = myActBoardService.getCalDataListService(user_id, input_date);
		System.out.println(hilsCalList);
		List<String> calDataList = new ArrayList<String>();
		Date tempDate = null;
		
		for(MyActCalendarDto dto : hilsCalList) {
			tempDate = dto.getWorkout_reg_date();
			calDataList.add(sdf.format(tempDate));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myActivitySchedule");
		mav.addObject("month", month);
		mav.addObject("year", year);
		mav.addObject("calDataList", calDataList);
		
		return mav;
	}
	
	/*힐린더 내용*/
	@RequestMapping("myActCal")
	public ModelAndView myActCal(HttpServletRequest request, String workout_reg_date) {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email"); // "dummy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Date target_date = null;
		try {
			target_date = simpleDateFormat.parse(workout_reg_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("log : " + target_date);
		//운동힐린더 정보 꺼내오기
		Date hilDate = setProfileService.latestdate(user_id); //"dummy"
		ProfileDto finder = new ProfileDto();
		finder.setUser_id(user_id);
		finder.setWorkout_reg_date(target_date);
		ProfileDto hilDto = setProfileService.workoutInfo1(finder); //아이디, 운동키, 날짜, 인증샷 정보
		System.out.println("hilDto:" + hilDto);
		List<ProfileDto> hilDto2 = setProfileService.workoutInfo2(hilDto); //운동이름, 운동칼로리 list
		//System.out.println(hilDto2.get(0).getWorkout_name());
		System.out.println("hilDto2:" + hilDto2);
		String imgName2 = getFileName(hilDto.getWorkout_certi_path());
		hilDto.setWorkout_certi_path(imgName2);
		
		//운동키와 같은 키의 식단힐린더 정보 꺼내오기
		List<ProfileDto> hilDto3 = setProfileService.dietInfo(hilDto.getWorkout_key());
		System.out.println("hilDto3:" + hilDto3);
		
		//mav에 정보를 add하여 mypage로 전송
		ModelAndView mav = new ModelAndView("myActCal");
		mav.addObject("woInfo1", hilDto);  //아이디, 운동키, 날짜, 인증샷
		mav.addObject("woInfo2", hilDto2);  //운동이름, 운동칼로리 list
		mav.addObject("dInfo", hilDto3);  //식품명, 몇인분, 칼로리, 목표칼로리
		
		System.out.println("내 힐린더 테스트: "+ hilDto + "," + hilDto2 + " , " + hilDto3);
		return mav;
	}
	
	public String getFileName(String path) {
		int index = path.lastIndexOf("\\");
		String fName = path.substring(index + 1);
		return fName;
	}
	
	/* 내 게시글 */
	@RequestMapping("viewMyPost")
	public String viewMyPost(
			HttpServletRequest request,
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "per", defaultValue = "10") int per,
			String category,
			String searchWord, 
			Model m
			) {
		
		HttpSession session = request.getSession();
		String myActUserId = (String)session.getAttribute("Email");

		MyActBoardListModel list = myActBoardService.myActBoardlist(pageNum, per, category, searchWord,myActUserId);
		System.out.println("myActBoardService: " + list);

		m.addAttribute("list",list);
		int number = list.getCount() - (pageNum - 1) * per;
		m.addAttribute("number",number);
		m.addAttribute("pageNum",pageNum);
		
		return "mypage2/mypagePost";
	}
	
	/* 내 게시글 ajax */
	@RequestMapping(value="viewMyPostJson", produces ="application/text;charset=utf-8")
	@ResponseBody
	public String viewMyPostJson(
			HttpServletRequest request,
			@RequestParam(value = "p", defaultValue = "1") int requestPage,
			@RequestParam(value = "category", defaultValue = "general") String category,
			@RequestParam(value = "per", defaultValue = "10") int per,
			String searchWord, 
			Model m) {
	
		HttpSession session = request.getSession();
		String myActUserId = (String)session.getAttribute("Email");
		List<MyActBoardDto> MyActBoardList = new ArrayList<>();
		
		int start = (requestPage - 1) * per + 1;
		int end = start * per;
		MyActBoardList = myActBoardService.selectmyActBoardService(start, end, category,myActUserId);
		
		System.out.println("MyActBoardList:" + MyActBoardList);
		
		m.addAttribute("MyActBoardList", MyActBoardList);
		m.addAttribute("category", category);
		
		/* 카테고리 분류시 카운트 where절 사용해서 가져오기.*/
		int count = myActBoardService.getPagingCategory(category,myActUserId);
		
		/*ajax 페이징 출력*/
		MyActBoardListModel list = myActBoardService.myActBoardlist(requestPage, per, category, searchWord,myActUserId);
		m.addAttribute("list",list);
		
		/*게시글 번호*/
		int number = myActBoardService.myActBoardCategoryCount(category,myActUserId);
		m.addAttribute("number",number);
		
		/*paging*/
		MyActPaging paging = new MyActPaging();
		paging.setPer(per);
		m.addAttribute("pazing", paging.paging(requestPage, count, per));
		m.addAttribute("requestPage",requestPage);
		
		m.addAttribute("pageNum",requestPage);
		
		Gson json = new Gson();
		return json.toJson(m);
	}

	public void setMyActBoardService(MyActBoardService myActBoardService) {
		this.myActBoardService = myActBoardService;
	}

	public void setSetProfileService(SetProfileService setProfileService) {
		this.setProfileService = setProfileService;
	}

	/*
	 * 	public String getShortString(String b_subject, Integer len) {
		// TODO Auto-generated method stub
		return null;
	}
	 * */
	
}
