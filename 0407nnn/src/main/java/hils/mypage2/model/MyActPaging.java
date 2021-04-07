package hils.mypage2.model;

public class MyActPaging {
	
	private int per;
	
	private int beginPageNumber;
	private int endPageNumber;
	private int totalPageNumber;
	
	public MyActPaging() {}
	public MyActPaging(int beginPageNumber, int endPageNumber, int totalPageNumber) {
		this.beginPageNumber = beginPageNumber;
		this.endPageNumber = endPageNumber;
		this.totalPageNumber = totalPageNumber;
	}
	public MyActPaging paging(int requestPage, int count, int per) {

		int pageC = 10; // 페이지 변경하고 싶으면 숫자를 변경한다!
		if (count == 0) {
			return new MyActPaging(0,0,0);
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
		
		return new MyActPaging(beginNumber, endNumber, pageCount);
		
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
