package hils.mainpage.model;

import java.util.ArrayList;
import java.util.List;

import hils.mainpage.service.MainBoardListPaging;
import hils.mypage2.model.MyActBoardDto;
import hils.mypage2.service.MyActBoardPaging;

public class MainBoardListModel {
	private int count;
	private List<MainBoardListDto> boardList;// 현재 페이지에서 보여질 글들
	private int requestPage;// 요청페이지
	private int totalPageCount;// 전체 페이지 수
	private int startRow;// 시작글
	private MainBoardListPaging p;
	
	public MainBoardListModel() {
		this(new ArrayList<MainBoardListDto>(), 0, 0, 0, new MainBoardListPaging(), 0);
	}

	public MainBoardListModel(List<MainBoardListDto> list, int requestPage, int totalPageCount, int startRow, MainBoardListPaging p,
			int count) {
		super();
		this.boardList = list;
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

	public List<MainBoardListDto> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<MainBoardListDto> boardList) {
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

	public MainBoardListPaging getP() {
		return p;
	}

	public void setP(MainBoardListPaging p) {
		this.p = p;
	}

	

}
