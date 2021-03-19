package hils.Mypage1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import hils.footer.controller.FooterDto;
import hils.footer.controller.FooterService;

@Controller
public class SetProfileController {
	
	@Autowired
	UserSettingService uset;
	
	/*
	 * @RequestMapping(value = "openAcc", method = RequestMethod.POST) //
	 * = @PostMapping(value = "") public void compInfo(HttpServletResponse resp)
	 * throws Exception { List<FooterDto> list = footS.selectInfo(); Gson json = new
	 * Gson(); //java -> json resp.setContentType("text/html;charset=utf-8"); //��������
	 * ����� ���� PrintWriter out = resp.getWriter(); //response��ü�� �����͸� ����ϴ� ��Ʈ�� ����
	 * out.print(json.toJson(list)); System.out.println(json.toJson(list)); }
	 */
	

	@PostMapping(value = "pwchanged")
	public String chPassword(HttpServletRequest request, HttpServletResponse res) throws IOException {
		String oldpw = request.getParameter("oldp");
		String newpw = request.getParameter("newp");
		int success = uset.changePw(oldpw, newpw);
		//java�ܿ��� alert ����
		PrintWriter out;
		out = res.getWriter();
		res.setContentType("text/html; charset=utf=8");
		if(success == 0) {
			out.println("<script language='javascript'>");
			out.println("alert('���� ����. �ٽ� �õ��ϼ���.');");
			out.println("</script>");
			out.flush();
			return "pwchange";
		}else {
			out.println("<script language='javascript'>");
			out.println("alert('��й�ȣ�� ����Ǿ����ϴ�.');");
			out.println("</script>");
			out.flush();
			return "usersetting";
		}
	}
	
	@RequestMapping("pwchange")
	public ModelAndView toPwchange(@RequestParam(value = "user_id") String user_id) {
		String pw = uset.getPw(user_id);
		System.out.println(pw);
		return new ModelAndView("pwchange", "pw", pw);
	}
	@RequestMapping("emailchange")
	public String toEmailchange() {
		return "emailchange";
	}
	@RequestMapping("phonechange")
	public String toPhonechange() {
		return "phonechange";
	}
	@RequestMapping("locset")
	public String toLocset() {
		return "locset";
	}
	
	
	/*
	@RequestMapping("")
	public ModelAndView toUsersetting() {
		List<ProfileDto> userInfo = uset.userInfo();
		return new ModelAndView("usersetting", "userInfo", userInfo);
	}
	*/
}
