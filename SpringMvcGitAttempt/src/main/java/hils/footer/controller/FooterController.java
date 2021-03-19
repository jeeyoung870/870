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
	
	//ajax��û�� ���� ��� list�� json�������� �����ش�.
		//HttpServletResponse resp : �޼ҵ尡 ������ resp(response��ü)�� �״�� �����ش�.(ù��° ���)
		@RequestMapping(value = "footerInfo", method = RequestMethod.POST)
		// = @PostMapping(value = "")
		public void compInfo(HttpServletResponse resp) throws Exception {
			List<FooterDto> list = footS.selectInfo();
			Gson json = new Gson(); 		//java -> json
			resp.setContentType("text/html;charset=utf-8");		//�������� ����� ����
			PrintWriter out = resp.getWriter(); 	//response��ü�� �����͸� ����ϴ� ��Ʈ�� ����
			out.print(json.toJson(list));
			//System.out.println(json.toJson(list));
		}

}
