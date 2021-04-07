package hils.managePosting1.service;

import java.util.List;

import hils.community.model.BoardDto;
import hils.managePosting1.model.ManagerSearchVO;

public interface IManageBoardService {
	public List<BoardDto> managerSearchBoardService(ManagerSearchVO managerSearchVO);
	public void doManagerDeleteArticle(int b_number);
	public BoardDto getBoardContent(int b_number);
	public void doManagerUpdateArticleService(BoardDto boardDto);
}
