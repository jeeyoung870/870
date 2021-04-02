package hils.ManageMainPage1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hils.footer.controller.FooterDto;
import hils.footer.controller.FooterService;


@Controller
public class CompInfoController {
	
	@Autowired
	FooterService footS;
	
	@RequestMapping("compinfo")
	public ModelAndView toCompinfo() {
		List<FooterDto> list = footS.selectInfo();
		//System.out.println(list.get(0));
		return new ModelAndView("compinfo", "comp", list.get(0));
	}
	
	@PostMapping(value = "compinfo")
	//d_address : 상세주소 
	public String changeLoc(HttpServletRequest request) {
		String company_name = request.getParameter("company_name");
		String representative_name = request.getParameter("representative_name");
		String business_license_number = request.getParameter("business_license_number");
		
		String postcode = request.getParameter("postcode");
		String address = request.getParameter("address");
		String d_address = request.getParameter("d_address");
		String business_address;
		if(postcode.equals("") || address.equals("") || d_address.equals("") ) {
			business_address = request.getParameter("business_address");
		}else {
			business_address = "("+postcode+") "+address+" "+d_address;
		}
		String phone_number = request.getParameter("phone_number");
		String fax_number = request.getParameter("fax_number");
		
		FooterDto fdto = new FooterDto();
		fdto.setCompany_name(company_name);
		fdto.setRepresentative_name(representative_name);
		fdto.setBusiness_license_number(business_license_number);
		fdto.setBusiness_address(business_address);
		fdto.setPhone_number(phone_number);
		fdto.setFax_number(fax_number);
		System.out.println(fdto);
		int success = footS.changeCInfo(fdto);
		System.out.println(success);
		return "redirect:main";
	}
}
