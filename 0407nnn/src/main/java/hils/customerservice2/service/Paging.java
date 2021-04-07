package hils.customerservice2.service;

public class Paging {
	int per;
	
	int beginPageNumber;
	int endPageNumber;
	int totalPageCount;
	
	public Paging() {}
	
	public Paging(int beginPageNumber, int endPageNumber, int totalPageCount) {
		super();
		this.beginPageNumber = beginPageNumber;
		this.endPageNumber = endPageNumber;
		this.totalPageCount = totalPageCount;
	}

	public Paging paging(int requestPage, int count, int per) {
		int pageC = 10; // 페이지 변경하고 싶으면 숫자를 변경한다!
		if (count == 0) {
			return new Paging(0,0,0);
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
		/*System.out.println(beginNumber+" : "+endNumber+":"+pageCount);*/
		
		return new Paging(beginNumber, endNumber, pageCount);
		
	}

	public int getPer() {
		return per;
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

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
		
	
}
