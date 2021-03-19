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
	public BoardPaging doPageCalculate(int requestPage, int totalWritingCount) {
		//?��?�빐�빞 �븯�뒗 寃껋�? 蹂댁뿬以�? begin pageNumber�� endpageNumber�씠�떎.
		//request page媛� 1�씠�씪硫�
		//1 2 3 4 5 6 7 8 9 �뿬湲곗�? 5源뚯�? �씠�룞�븳 �썑 洹� �떎�쓬?����꽣�?��
		//2 3 4 5 6 7 8 9 10 �씠�윴 �떇�쑝濡� 蹂댁뿬以�? 寃�
		totalPageNumber = totalWritingCount / per; //5.5 �씪硫�
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
