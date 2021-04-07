package board.service;

import lombok.Getter;

@Getter
public class Paging {

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
		int pagingNum = 10;	//페이지번호를 보여줄 개수
		
		if (count == 0) {
			return new Paging(0,0,0);
		}
		int pageCount = count / per;
		if (count % per > 0) {
			pageCount++;
		}
		//페이지번호 몇개까지 보여줄건지 설정
		int beginNumber = (requestPage - 1) / pagingNum * pagingNum + 1;
		int endNumber = beginNumber + pagingNum-1;
		if(endNumber > pageCount) {
			endNumber = pageCount;
		}
		return new Paging(beginNumber, endNumber, pageCount);
		
	}
}
