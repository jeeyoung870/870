package hils.Report.Controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hils.Report.Model.ReportDto;
import hils.Report.Service.ReportService;

@Controller
@RequestMapping(value = "/report")
public class ReportController {
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	private ReportService service = new ReportService();

	public ReportService getService() {
		return service;
	}

	public void setService(ReportService service) {
		this.service = service;
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String ReportList(Locale locale, Model model) throws Exception {

		logger.info("home"); 
		List<ReportDto> ReportList = service.selectReport();
		model.addAttribute("ReportList", ReportList);
		
		System.out.println(ReportList);

		return "report/reportMain";
	}
//
//	// 신고 내용 DB에 전송
//	@RequestMapping(value = "/insertDBReport")
//	public void insertData(@RequestParam Map<String, Object> param, HttpServletRequest request, ReportDto ReportDto) {
//		System.out.println("param::" + param);
//		ReportService.insertMethod(param);
//	}
//	
	// 신고 항목 삭제
	@RequestMapping(value = "/deleteDBReport")
	public String ReportDelete(HttpServletRequest request) {
		String[] deleteMsg = request.getParameterValues("valueArr");
		int size = deleteMsg.length;
		for(int i=0; i<size; i++) {
			service.deleteMethod(deleteMsg[i]);
		}
		return "report/reportMain";
	}
	
	@RequestMapping(value = "/ReportPass")
	public String ReportDelete() {
		return "report/reportReturn";
	}
}