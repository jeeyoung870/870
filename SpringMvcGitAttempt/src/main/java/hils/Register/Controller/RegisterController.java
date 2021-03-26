package hils.Register.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hils.Register.Model.RegisterDto;
import hils.Register.Service.RegisterService;

@Controller
@RequestMapping("user")
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private RegisterService service;

	public RegisterService getService() {
		return service;
	}

	public void setService(RegisterService service) {
		this.service = service;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {
		logger.info("get register");
	}

	// 회원가입 post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(RegisterDto regiDto) throws Exception {
		logger.info("post register");
		System.out.println("called");
		service.register(regiDto);

		return "mainPage";
	}
}