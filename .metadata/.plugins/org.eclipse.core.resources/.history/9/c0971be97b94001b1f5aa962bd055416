package hils.Mypage1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import hils.footer.controller.FooterDto;
import hils.footer.controller.FooterService;

@Controller
public class SettingController {
	
	@Autowired
	UserSettingService uset;
	
	//설정 및 회원정보로 이동
	@RequestMapping("usersetting")
	public ModelAndView toUsersetting() {
		List<ProfileDto> userInfo = uset.userInfo("jyjy");
		//pw를 *로 출력하기 위한 코드
		String pw = userInfo.get(0).getPassword();
		String pwpw = "";
		for(int i=0; i < pw.length(); i++) {
			pwpw += "*";
		}
		userInfo.get(0).setPassword(pwpw);
		return new ModelAndView("usersetting", "userInfo", userInfo);
	}
	
	//비밀번호 변경하기
	@PostMapping(value = "pwchanged", produces = "application/text; charset=UTF-8")
	public String chPassword(@RequestParam(value = "user_id") String user_id, 
			HttpServletRequest request, HttpServletResponse res) throws IOException {
		String newpw = request.getParameter("newp");
		ProfileDto pdto = new ProfileDto();
		pdto.setUser_id(user_id);
		pdto.setPassword(newpw);
		System.out.println(user_id + "  "+newpw);
		int success = uset.changePw(pdto);
		System.out.println(success);
		return "redirect:usersetting";
	}
	
	@RequestMapping("pwchange")
	public ModelAndView toPwchange(@RequestParam(value = "user_id") String user_id) {
		String pw = uset.getPw(user_id);
		ArrayList<String> user = new ArrayList<>();
		user.add(user_id);
		user.add(pw);
		return new ModelAndView("pwchange", "user", user);
	}
	
	@RequestMapping("emailchange")
	public ModelAndView toEmailchange(@RequestParam(value = "user_id") String user_id) {
		return new ModelAndView("emailchange", "user", user_id);
	}
	
	 //이메일 인증용 메일 보내기
	 @PostMapping(value="mailcheck", produces = "text/plain;charset=UTF-8")
		@ResponseBody	//가 받은 객체를 클라이언트view로 보냄
	    public String sendMail(String newmail) throws Exception {
		 	System.out.println(newmail);
	        EmailVO email = new EmailVO();
				/*
				 * String receiver = "메일 받을 주소"; 
				 * String subject = "Email 제목"; 
				 * String content = "Email 내용";
				 */
	         String receiver = newmail;
	         String subject  = "[HILS]메일 확인용 인증번호 전송";
	         String content = "아래의 숫자를 정확하게 입력해 주세요.\n";

	        email.setReceiver(receiver);
	        email.setSubject(subject);
	        email.setContent(content);
	        
	        int min = 1000;
	        int max = 9999;
	        int random = (int) ((Math.random() * (max - min)) + min);  //1000~9999 중에서 랜덤뽑기
	        boolean result = uset.sendMail(email, random);	//성공시 true, 실패시 false
	        System.out.println(result);
	        
	        Gson json = new Gson(); 
			System.out.println(json.toJson(random));
			return json.toJson(random);	
			/* return "random:"+random; */

	    }
	 //이메일 변경
	 @PostMapping(value = "emailchanged")
		public String chEmail(@RequestParam(value = "user_id") String user_id, 
				@RequestParam(value = "newmail") String newmail,
				HttpServletRequest request, HttpServletResponse res) throws IOException {
			ProfileDto pdto = new ProfileDto();
			pdto.setUser_id(user_id);
			pdto.setUser_email(newmail);
			System.out.println(user_id + "  "+newmail);
			int success = uset.changeEmail(pdto);
			System.out.println(success);
			//java단에서 alert 띄우기
			return "redirect:usersetting";
		}
		  
	 
	@RequestMapping("phonechange")
	public ModelAndView toPhonechange(@RequestParam(value = "user_id") String user_id) {
		String phone = uset.getPhone(user_id);
		ProfileDto user = new ProfileDto();
		user.setUser_id(user_id);
		user.setUser_phone(phone);
		return new ModelAndView("phonechange", "user", user);
	}
	
	//ajax - 변경할 phone연락처가 다른 사용자와 중복인지 체크
	@RequestMapping(value = "phonecheck", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody  
	public String phoneCheck(String newphone) throws Exception {
		int count = uset.phoneCheck(newphone);
		/* List<Map<String,Object>> list = emp.selectEmps(deptno); */
		Gson json = new Gson(); 
		System.out.println(json.toJson(count));
		//부서번호로 검색한 ename을 리턴함
		return json.toJson(count);	
	}
	//phone 변경하기
	@PostMapping(value = "phonechanged",  produces = "application/text; charset=UTF-8")
	public String chPhone(@RequestParam(value = "user_id") String user_id, 
			HttpServletRequest request, HttpServletResponse res) throws IOException {
		String newphone = request.getParameter("newphone");
		ProfileDto pdto = new ProfileDto();
		pdto.setUser_id(user_id);
		pdto.setUser_phone(newphone);
		System.out.println(user_id + "  "+newphone);
		int success = uset.changePhone(pdto);
		System.out.println(success);
		return "redirect:usersetting";
	}
	
	//힐린더 비공개여부 변경
	@PostMapping(value = "hilopenchange")
	public String chHilendarOpen(char data, String user_id) {
		System.out.println(data + user_id);
		ProfileDto pdto = new ProfileDto();
		pdto.setUser_id(user_id);
		pdto.setIs_hellinder_open(data);
		int success = uset.changeHilOpen(pdto);
		System.out.println(success);
		return "redirect:usersetting";
	}
	
	//힐린더 게시판 연동여부 변경
	@PostMapping(value = "hilwithboard")
	public String chHilWithBoard(char data, String user_id) {
		System.out.println(data + user_id);
		ProfileDto pdto = new ProfileDto();
		pdto.setUser_id(user_id);
		pdto.setIs_withboard(data);
		int success = uset.changeHilWB(pdto);
		System.out.println(success);
		return "redirect:usersetting";
	}
	
	
	@RequestMapping("locset")
	public String custUpdate(String user_id, Model m) {
		m.addAttribute("user_id", user_id);
		return "locset";
	}
	
	//위치 설정하기
	@PostMapping(value = "locset")
	//d_address : 상세주소 
	public String changeLoc(HttpServletRequest request, String user_id) {
		String postcode = request.getParameter("postcode");
		String address = request.getParameter("address");
		//String d_address = request.getParameter("d_address");
		ProfileDto pdto = new ProfileDto();
		pdto.setLocation(address);
		pdto.setUser_id(user_id);
		int success = uset.changeLoc(pdto);
		System.out.println(success);
		return "redirect:usersetting";
	}
	
}
