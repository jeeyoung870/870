package hils.manageintro.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import hils.manageintro.service.IntroService;

@Controller
public class IntroController {
	
	@Autowired
	IntroService service;
	
	@RequestMapping("manageIntro")
	public String manageIntro() {
		
		return "manageIntro/introManagement";
	}
	
	// ajax를 이용한 신규 가입자 통계
	@RequestMapping(value="subscriberStatistics", produces ="application/text;charset=utf-8")
	@ResponseBody
	public String faqView(Model m) {
	
		/*ajax 페이징 출력*/
		Map<String,Integer> list = service.subscriberStatistics();
		List<Integer> processedList = new ArrayList<Integer>();
		System.out.println("list: "+ list);
		for(int i = 1; i <= 12 ; i ++) {
			for(String key : list.keySet()) {
				if(i == Integer.parseInt(key)) {
					Integer test1 = Integer.parseInt(String.valueOf(list.get(key)));
					processedList.add(test1);
				}
			}
		}
		System.out.println(processedList);
		
		m.addAttribute("list",processedList);

		Gson json = new Gson();
		return json.toJson(m);
	}

	public void setService(IntroService service) {
		this.service = service;
	}
	
}
