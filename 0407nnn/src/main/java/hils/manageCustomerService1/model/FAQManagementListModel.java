package hils.manageCustomerService1.model;

import java.util.ArrayList;
import java.util.List;

import hils.manageCustomerService1.service.ManagementPaging;

public class FAQManagementListModel {
	private int count;
	private List<FAQManagementDto> boardList;// 현재 페이지에서 보여질 글들
	private int requestPage;// 요청페이지
	private int totalPageCount;// 전체 페이지 수
	private int startRow;// 시작글
	private ManagementPaging p;
	
	public FAQManagementListModel() {
		this(new ArrayList<FAQManagementDto>(), 0, 0, 0, new ManagementPaging(), 0);
	}

	public FAQManagementListModel(List<FAQManagementDto> boardList, int requestPage, int totalPageCount, int startRow, ManagementPaging p,
			int count) {
		super();
		this.boardList = boardList;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.p = p;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<FAQManagementDto> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<FAQManagementDto> boardList) {
		this.boardList = boardList;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public ManagementPaging getP() {
		return p;
	}

	public void setP(ManagementPaging p) {
		this.p = p;
	}

	
	
	
}
