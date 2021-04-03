package hils.mainpage.service;

public class MainBoardListPaging {

	int beginPageNumber;
	int endPageNumber;
	int totalPageCount;
	
	public MainBoardListPaging() {}
	
	public MainBoardListPaging(int beginPageNumber, int endPageNumber, int totalPageCount) {
		super();
		this.beginPageNumber = beginPageNumber;
		this.endPageNumber = endPageNumber;
		this.totalPageCount = totalPageCount;
	}

	public MainBoardListPaging paging(int requestPage, int count, int per) {
		int pageC = 10; // 페이지 변경하고 싶으면 숫자를 변경한다!
		if (count == 0) {
			return new MainBoardListPaging(0,0,0);
		}
		int pageCount = count / per;
		if (count % per > 0) {
			pageCount++;
		}
		int beginNumber = (requestPage - 1) / pageC * pageC + 1;
		int endNumber = beginNumber + pageC - 1;
		if(endNumber > pageCount) {
			endNumber = pageCount;
		}
		return new MainBoardListPaging(beginNumber, endNumber, pageCount);
		
	}

	public int getBeginPageNumber() {
		return beginPageNumber;
	}

	public int getEndPageNumber() {
		return endPageNumber;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}
}
