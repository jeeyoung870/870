package hils.ManageUser.Controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hils.ManageUser.Service.ManageUserService;
import hils.Register.Model.RegisterDto;
import hils.Report.Model.PagingDto;
import hils.Report.Model.ReportDto;

@Controller
public class ManageUserController {
	private static final Logger logger = LoggerFactory.getLogger(ManageUserController.class);

	@Autowired
	private ManageUserService service = new ManageUserService();

	public ManageUserService getService() {
		return service;
	}

	public void setService(ManageUserService service) {
		this.service = service;
	}

	// 유저 목록 조회
		@RequestMapping(value = "userSelect", method = RequestMethod.GET)
		public String UserList(PagingDto registerPagingDto, Model model
				, @RequestParam(value="nowPage", required=false)String nowPage
				, @RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception {
			System.out.println(registerPagingDto);
			
			int total = service.countMethod();
			System.out.println(total);
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "8";
			} else if (nowPage == null) {
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "8";
			}
			registerPagingDto = new PagingDto(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			model.addAttribute("paging", registerPagingDto);
			System.out.println(registerPagingDto);
			
			List<RegisterDto> UserList = service.selectUserMethod(registerPagingDto);
			model.addAttribute("UserList", UserList);
			System.out.println(UserList);
			return "user/userList";
		}

	// 유저 삭제
	@RequestMapping(value = "userDelete")
	public String userDelete(HttpServletRequest request) {
		String[] deleteMsg = request.getParameterValues("valueArr");
		int size = deleteMsg.length;
		for (int i = 0; i < size; i++) {
			service.deleteMethod(deleteMsg[i]);
		}
		return "user/userList";
	}
	
	// 유저 휴면회원처리
	@RequestMapping(value = "userDormancy")
	public String userDormancyForm() {
		System.out.println("휴면 요청 시작");
		return "user/dormancy";
	}
	
	// 유저 휴면회원처리
	@RequestMapping(value = "userDormancy", method = RequestMethod.POST)
	public String userDormancy(RegisterDto dormancy) {
		System.out.println("휴면 설정 시작");
		service.dormancyMethod(dormancy);
		System.out.println("휴면해제 설정 정보: "+dormancy);
		return "user/dormancyExit";
	}
	
	// 유저 휴면회원처리
	@RequestMapping(value = "userDormancyCancle")
	public String userDormancyCancleForm() {
		System.out.println("휴면해제 요청 시작");
		return "user/dormancyCancle";
	}
	
	// 유저 휴면회원처리
	@RequestMapping(value = "userDormancyCancle", method = RequestMethod.POST)
	public String userDormancyCancle(RegisterDto user_id) {
		System.out.println("휴면 해제 시작");
		service.dormancyCancleMethod(user_id);
		System.out.println("휴면해제 회원 정보: "+user_id);
		return "user/dormancyExitCancle";
	}
	
	@RequestMapping(value = "userPass")
	public String ReportDelete() {
		return "user/userListReturn";
	}
}
