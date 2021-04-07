package hils.Report.Controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hils.Report.Model.PagingDto;
import hils.Report.Model.ReportDto;
import hils.Report.Service.ReportService;

@Controller
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

	// 신고작성
	@RequestMapping(value = "reportWrite")
	public String WriteForm() {
		System.out.println("신고 작성 시작");
		return "report/reportForm";
	}
	
	// 신고등록 성공
	@RequestMapping(value = "reportWrite", method = RequestMethod.POST)
	public String Write(ReportDto write) {
		System.out.println("신고 등록 시작");
		service.writeMethod(write);
		System.out.println(write);
		return "report/reportExit";
	}

	// 신고 목록 조회
	@GetMapping(value="select")
	public String boardList(PagingDto pagingDto, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception {
		System.out.println(pagingDto);
		
		int total = service.countBoard();
		System.out.println(total);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "8";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "8";
		}
		pagingDto = new PagingDto(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", pagingDto);
		System.out.println(pagingDto);
		
		List<ReportDto> ReportList = service.selectReportBoard(pagingDto);
		model.addAttribute("ReportList", ReportList);
		System.out.println(ReportList);
		return "report/reportMain";
	}

	// 신고 항목 삭제
	@RequestMapping(value = "deleteDBReport")
	public String ReportDelete(HttpServletRequest request) {
		String[] deleteMsg = request.getParameterValues("valueArr");
		int size = deleteMsg.length;
		for (int i = 0; i < size; i++) {
			service.deleteMethod(deleteMsg[i]);
		}
		return "report/reportMain";
	}

	@RequestMapping(value = "ReportPass")
	public String ReportDelete() {
		return "report/reportReturn";
	}
}