package hils.footer.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
public class FooterController {
	@Autowired
	FooterService footS;
	
	//ajax요청에 따라 결과 list를 json형식으로 돌려준다.
		//HttpServletResponse resp : 메소드가 끝나면 resp(response객체)를 그대로 돌려준다.(첫번째 방법)
		@RequestMapping(value = "footerInfo", method = RequestMethod.POST)
		// = @PostMapping(value = "")
		public void compInfo(HttpServletResponse resp) throws Exception {
			List<FooterDto> list = footS.selectInfo();
			Gson json = new Gson(); 		//java -> json
			resp.setContentType("text/html;charset=utf-8");		//응답정보 결과물 설정
			PrintWriter out = resp.getWriter(); 	//response객체에 데이터를 출력하는 스트림 연결
			out.print(json.toJson(list));
			//System.out.println(json.toJson(list));
		}

}
