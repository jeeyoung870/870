package hils.mypage2.model;

import java.util.ArrayList;
import java.util.List;

import hils.manageCustomerService1.service.ManagementPaging;
import hils.mypage2.service.MyActBoardPaging;

public class MyActBoardListModel {
	private int count;
	private List<MyActBoardDto> boardList;// 현재 페이지에서 보여질 글들
	private int requestPage;// 요청페이지
	private int totalPageCount;// 전체 페이지 수
	private int startRow;// 시작글
	private MyActBoardPaging p;
	
	public MyActBoardListModel() {
		this(new ArrayList<MyActBoardDto>(), 0, 0, 0, new MyActBoardPaging(), 0);
	}

	public MyActBoardListModel(List<MyActBoardDto> boardList, int requestPage, int totalPageCount, int startRow, MyActBoardPaging p,
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

	public List<MyActBoardDto> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<MyActBoardDto> boardList) {
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

	public MyActBoardPaging getP() {
		return p;
	}

	public void setP(MyActBoardPaging p) {
		this.p = p;
	}

}
