package download.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import download.model.PageRankReport;

@Controller
public class PageRanksController {
	
	@RequestMapping("/pageRanks")
	public ModelAndView handleRequestInternal() {
		//다운로드할 엑셀파일에 들어갈 셀 데이터들을 List로 만들기
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "/bbs/mir2/list"));
		pageRanks.add(new PageRank(2, "/bbs/mir3/list"));
		pageRanks.add(new PageRank(3, "/bbs/changchun2/list"));
		//ModelAndView("뷰이름", "모델이름", 모델의객체)
		return new ModelAndView("pageRanks", "pageRanks", pageRanks);
	}
	
	@RequestMapping("/pageXmlReport")
	public ModelAndView xmlReport() {
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "/bbs/mir2/list"));
		pageRanks.add(new PageRank(2, "/bbs/mir3/list"));
		pageRanks.add(new PageRank(3, "/bbs/changchun2/list"));
		return new ModelAndView("pageXmlReport", "report", new PageRankReport(pageRanks));
	}
	
	@RequestMapping("/pageJsonReport")
	public ModelAndView jsonReport() {
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "/bbs/mir2/list"));
		pageRanks.add(new PageRank(2, "/bbs/mir3/list"));
		pageRanks.add(new PageRank(3, "/bbs/changchun2/list"));
		return new ModelAndView("pageJsonReport", "report", new PageRankReport(
				pageRanks));
	}

}
