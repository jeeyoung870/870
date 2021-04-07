package download.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import download.controller.PageRank;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rank-report")	// xml의 최상위태그이름 정하기
public class PageRankReport {

	@XmlElement(name = "page-rank") //"page-rank"라는 태그 사이에 List추가
	private List<PageRank> pageRanks;

	public PageRankReport() {
	}
	
	public PageRankReport(List<PageRank> pageRanks) {
		this.pageRanks = pageRanks;
	}

	public List<PageRank> getPageRanks() {
		return pageRanks;
	}

}