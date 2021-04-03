package hils.mainpage.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hils.mainpage.model.MainBoardListDto;
import hils.mainpage.model.MainBoardListModel;
import hils.mainpage.service.MainPageService;

@Controller
public class MainPageController {

	@Autowired
	private MainPageService mainPageService;
	
	@RequestMapping("main")
	public String showMainPage(
			HttpServletRequest request,
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "per", defaultValue = "10") int per,
			Model m
			){
		// 로그인 이메일 정보
		HttpSession session = request.getSession();
		System.out.println((String)session.getAttribute("Email"));
		String mainUserId = (String)session.getAttribute("Email");
		
		// 유저 활동 리스트 출력 메소드
		String[] displayDate = date();
		List<String> userList = mainPageService.mainUserlist(displayDate[0], displayDate[1]);
		System.out.println("userList: "+ userList);
		m.addAttribute("userList", userList);
		
		// 최신 게시글 출력 메소드
		MainBoardListModel list = mainPageService.mianBoardlist(pageNum, per);
		m.addAttribute("list",list);
		
		return "mainPage";
	}
	
	public String[] date() {
		Calendar calendar = Calendar.getInstance();
		System.out.println("calendar: " + calendar.getTime());
		String format = "yyyyMMdd";
		SimpleDateFormat simpleDate = new SimpleDateFormat(format);
		String bgndate  =  simpleDate.format(calendar.getTime());
		String enddate   = simpleDate.format(calendar.getTime());

		calendar.set(Calendar.YEAR,Integer.parseInt(bgndate.substring(0,4)));
		calendar.set(Calendar.MONTH,Integer.parseInt(bgndate.substring(4,6))-1);
		calendar.set(Calendar.DATE,1);

		calendar.add(Calendar.MONTH,0);
		Date sDate = calendar.getTime();

		String main_bgndate = simpleDate.format(sDate);

		calendar.set(Calendar.YEAR,Integer.parseInt(enddate.substring(0,4)));
		calendar.set(Calendar.MONTH,Integer.parseInt(enddate.substring(4,6))-1);
		calendar.set(Calendar.DATE,1);

		calendar.add(Calendar.MONTH,1);
		calendar.add(Calendar.DATE,-1);
		Date sDate2 = calendar.getTime();

		String main_enddate = simpleDate.format(sDate2);
	
        String[] dateDisplay = {main_bgndate,main_enddate};
        
        return dateDisplay;
	}
	
	public void setMainPageService(MainPageService mainPageService) {
		this.mainPageService = mainPageService;
	}
}
