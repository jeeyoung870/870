package board.model;

import java.util.ArrayList;
import java.util.List;

import board.service.Paging;
import files.model.FBoardDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListModel {
	
	private int count;
	private List<BoardDto> boardList;//현재 페이지에서 보여질 게시판글들
	//private List<FBoardDto> fBoardList;	//자료실글
	private int requestPage;//요청페이지
	private int totalPageCount;//전체 페이지 수
	private int startRow;//시작글
	private Paging p;
	private int per;
	
	
	  public BoardListModel(List<BoardDto> boardList, int requestPage, int totalPageCount, 
			  int startRow, Paging p,int count) { 
		  super(); 
		  this.boardList = boardList; 
		  this.requestPage = requestPage; 
		  this.totalPageCount =totalPageCount; 
		  this.startRow = startRow; 
		  this.p = p; 
		  this.count = count;
	  }
	  
	
	public BoardListModel() {
		this(new ArrayList<BoardDto>(), 0, 0, 0, new Paging(),0);	
	}
	
	
	
}
