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

import hils.ManageUser.Service.ManageUserService;
import hils.Register.Model.RegisterDto;

@Controller
@RequestMapping(value = "/manage")
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

	@RequestMapping(value = "/userSelect", method = RequestMethod.GET)
	public String UserList(Locale locale, Model model) throws Exception {

		logger.info("home");
		List<RegisterDto> UserList = service.selectMethod();
		model.addAttribute("UserList", UserList);

		System.out.println(UserList);

		return "user/userList";
	}

	// 유저 삭제
	@RequestMapping(value = "/userDelete")
	public String ReportDelete(HttpServletRequest request) {
		String[] deleteMsg = request.getParameterValues("valueArr");
		int size = deleteMsg.length;
		for (int i = 0; i < size; i++) {
			service.deleteMethod(deleteMsg[i]);
		}
		return "user/userList";
	}

	@RequestMapping(value = "/userPass")
	public String ReportDelete() {
		return "user/userListReturn";
	}
}
