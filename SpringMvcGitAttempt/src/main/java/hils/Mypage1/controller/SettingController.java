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
	
	//��й�ȣ �����ϱ�
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
		//java�ܿ��� alert ����
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
	
	 //�̸��� ������ ���� ������
	 @PostMapping(value="mailcheck", produces = "text/plain;charset=UTF-8")
		@ResponseBody	//�� ���� ��ü�� Ŭ���̾�Ʈview�� ����
	    public String sendMail(String newmail) throws Exception {
		 	System.out.println(newmail);
	        EmailVO email = new EmailVO();
				/*
				 * String receiver = "���� ���� �ּ�"; 
				 * String subject = "Email ����"; 
				 * String content = "Email ����";
				 */
	         String receiver = newmail;
	         String subject  = "[HILS]���� Ȯ�ο� ������ȣ ����";
	         String content = "�Ʒ��� ���ڸ� ��Ȯ�ϰ� �Է��� �ּ���.\n";

	        email.setReceiver(receiver);
	        email.setSubject(subject);
	        email.setContent(content);
	        
	        int min = 1000;
	        int max = 9999;
	        int random = (int) ((Math.random() * (max - min)) + min);  //1000~9999 �߿��� �����̱�
	        boolean result = uset.sendMail(email, random);	//������ true, ���н� false
	        System.out.println(result);
	        
	        Gson json = new Gson(); 
			System.out.println(json.toJson(random));
			return json.toJson(random);	
			/* return "random:"+random; */

	    }
	 //�̸��� ����
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
			//java�ܿ��� alert ����
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
	
	//ajax - ������ phone����ó�� �ٸ� ����ڿ� �ߺ����� üũ
	@RequestMapping(value = "phonecheck", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody  
	public String phoneCheck(String newphone) throws Exception {
		int count = uset.phoneCheck(newphone);
		/* List<Map<String,Object>> list = emp.selectEmps(deptno); */
		Gson json = new Gson(); 
		System.out.println(json.toJson(count));
		//�μ���ȣ�� �˻��� ename�� ������
		return json.toJson(count);	
	}
	//phone �����ϱ�
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
	
	//������ ��������� ����
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
	
	//������ �Խ��� �������� ����
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
	
	//��ġ �����ϱ�
	@PostMapping(value = "locset")
	//d_address : ���ּ� 
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
