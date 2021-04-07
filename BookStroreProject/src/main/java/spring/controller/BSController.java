package spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import lombok.Setter;
import spring.model.customDto;
import spring.model.salesDto;
import spring.service.BSService;
import spring.validator.customerValidator;

@Setter
@Controller
public class BSController {
	
	@Autowired
	BSService bs;
	
	@GetMapping(value = "/bs/purchaseHistory.do")
	public String menu1() throws Exception {
		return "bs/purchaseHistory";
	}
	@GetMapping(value = "/bs/newCustomer.do")
	public String menu2() throws Exception {
		return "bs/newCustomer";
	}
	@GetMapping(value = "/bs/updateCustomer.do")
	public String custList1(Model model) {
		List<customDto> list = bs.allCust();
		model.addAttribute("allCust", list);
		return "bs/updateCustomer";
	}
	@GetMapping(value = "/bs/changeAddress.do")
	public String custUpdate(int custid, Model m) {
		m.addAttribute("custid", custid);
		return "bs/changeAddress";
	}
	@PostMapping(value = "/bs/changeAddress.do")
	//dto : custid와 address저장된 객체, d_address : 상세주소 
	public String Updated(customDto dto, String d_address) {
		dto.setAddress(dto.getAddress() + " " + d_address);
		System.out.println(dto.getAddress());
		bs.updateAddr(dto);
		return "redirect:/menu.jsp";
	}
	
	
	@RequestMapping(value = "/bs/purchaseHistory.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody  // -->리턴되는 데이터가 response객체에 담겨 클라이언트로 돌아간다.(두번째 방법)
	public String findSales(int category, String word) throws Exception {
		System.out.println("word::"+word);
		List list;
		if(category == 1) {
			list = bs.bookSales(word);
		}else if(category == 2) {
			List aaa = bs.customSales1(word);
			List bbb = bs.customSales2(word);
			list = new ArrayList();
			list.add(aaa);
			list.add(bbb);
		}else {
			list = new ArrayList();
			String str = "검색조건을 선택하세요.";
			list.add(str);
		}
		Gson json = new Gson();
		System.out.println(json.toJson(list));
		return json.toJson(list);
	}
	
	@RequestMapping(value = "/bs/newCustid.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody  // -->리턴되는 데이터가 response객체에 담겨 클라이언트로 돌아간다.(두번째 방법)
	public String getNewCustid() throws Exception {
		int custid = bs.newCustid();
		Gson json = new Gson();
		System.out.println(json.toJson(custid));
		return json.toJson(json.toJson(custid));
	}
	
	@RequestMapping(value= "/bs/addCust.do", method = RequestMethod.POST)
	//command로 넘어온 파라미터값 저장
	public String submit(@ModelAttribute("command") customDto custDto, BindingResult result) {
		System.out.println("이름"+custDto.getName());
		new customerValidator().validate(custDto, result);
		if (result.hasErrors()) {
			//BindingResult객체에 에러메시지가 있다면,
			return "bs/newCustomer";
		}
		//에러없으면,(칸 다채웠으면)
		int check = bs.insertCust(custDto);
		if(check == 1) {	//성공시
			//result.rejectValue("addResult", "addSuccess");
			return "redirect:/menu.jsp";
		} else {	//실패시
			//result.rejectValue("addResult", "addFail");
			return "bs/newCustomer";
		}
	}
	
	/*
	 * @RequestMapping(value = "/bs/custList.do", method = RequestMethod.POST,
	 * produces = "text/plain;charset=UTF-8")
	 * 
	 * @ResponseBody public String custList() throws Exception { List<customDto>
	 * list = bs.allCust(); Gson json = new Gson();
	 * System.out.println(json.toJson(list)); return json.toJson(json.toJson(list));
	 * }
	 */
}
