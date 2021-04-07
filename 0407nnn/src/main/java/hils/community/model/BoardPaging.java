package hils.community.model;

public class BoardPaging {
	
	private int per;
	
	private int beginPageNumber;
	private int endPageNumber;
	private int totalPageNumber;
	
	private final int magicPageNumber = 10;
	private final int pageMiddlePoint = 5;
	
	public BoardPaging() {}
	public BoardPaging(int beginPageNumber, int endPageNumber, int totalPageNumber) {
		this.beginPageNumber = beginPageNumber;
		this.endPageNumber = endPageNumber;
		this.totalPageNumber = totalPageNumber;
	}
	//페이징이 의도한 대로 이루어지는지 확인
	public BoardPaging doPageCalculate(int requestPage, int totalWritingCount) {
		
		totalPageNumber = totalWritingCount / per; 
		if(totalWritingCount % per > 1) {
			totalPageNumber += 1;
		}
		if(requestPage > pageMiddlePoint) {
			beginPageNumber = requestPage - pageMiddlePoint + 1;
			endPageNumber = requestPage + pageMiddlePoint;
			if(requestPage + pageMiddlePoint > totalPageNumber) {
				endPageNumber = totalPageNumber;
			}
		}else {
			beginPageNumber = 1;
			endPageNumber = 9;
			if (totalPageNumber < endPageNumber) {
				endPageNumber = totalPageNumber;
			}
		}
		System.out.println(endPageNumber);
		return new BoardPaging(beginPageNumber, endPageNumber, totalPageNumber);
	}
	public void setPer(int per) {
		this.per = per;
	}
	public int getBeginPageNumber() {
		return beginPageNumber;
	}
	public void setBeginPageNumber(int beginPageNumber) {
		this.beginPageNumber = beginPageNumber;
	}
	public int getEndPageNumber() {
		return endPageNumber;
	}
	public void setEndPageNumber(int endPageNumber) {
		this.endPageNumber = endPageNumber;
	}
	public int getTotalPageNumber() {
		return totalPageNumber;
	}
	public void setTotalPageNumber(int totalPageNumber) {
		this.totalPageNumber = totalPageNumber;
	}
	
	
}
