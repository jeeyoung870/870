package hils.community.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.community.model.BoardDto;
import hils.community.model.LikeThumbDto;
import hils.community.model.SubBoardDto;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public List<BoardDto> selectBoardListService(int start, int end, String b_category){
		HashMap <String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("start_writing_num", start);
		paraMap.put("end_writing_num", end);
		paraMap.put("b_category", b_category);
		return boardDao.selectBoardList(paraMap);
	}
	public int checkTotalArticleCountService() {
		return boardDao.checkTotalArticleCount();
	}
	public void insertNewArticleService(BoardDto boardDto) {
		boardDao.insertNewArticle(boardDto);
	}
	public BoardDto selectSpecificContentService(int b_number) {
		return boardDao.selectSpecificContent(b_number);
	}
	public List<BoardDto> selectSpecificCategoryService(String b_category){
		return boardDao.selectSpecificCategory(b_category);
	}
	public void updateArticleService(String b_content, String b_subject, int b_number) {
		HashMap<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("b_content", b_content);
		paraMap.put("b_subject", b_subject);
		paraMap.put("b_number", b_number);
		boardDao.updateArticle(paraMap);
	}
	public void readcountUpService(int b_number) {
		boardDao.readcountUp(b_number);
	}
	
	// subBoard
	public List<SubBoardDto> selectSpecificSubBoardListService(int b_number){
		return boardDao.selectSpecificSubBoardList(b_number);
	}
	public int selectCommentNumberService() {
		return boardDao.selectCommentNumber();
	}
	public void insertNewCommentService(SubBoardDto subBoardDto) {
		boardDao.insertNewComment(subBoardDto);
	}
	//noti
	public String selectBoardSubjectService(int b_number) {
		return boardDao.selectBoardSubject(b_number);
	}
	//like thumb
	public void newLikeThumbService(int b_number, String user_id) {
		LikeThumbDto likeDto = new LikeThumbDto();
		likeDto.setUser_id(user_id);
		likeDto.setWriting_num(b_number);
		
		boardDao.newLikeThumb(likeDto);
	}
	public void cancelThumbService(int b_number, String user_id) {
		LikeThumbDto likeDto = new LikeThumbDto();
		likeDto.setUser_id(user_id);
		likeDto.setWriting_num(b_number);
		
		boardDao.cancelThumb(likeDto);
	}
	public String isThumbService(int b_number, String user_id) {
		LikeThumbDto likeDto = new LikeThumbDto();
		likeDto.setUser_id(user_id);
		likeDto.setWriting_num(b_number);
		
		return boardDao.isLikeThumbed(likeDto);
	}
	public void thumbUpCountService(int b_number) {
		boardDao.thumbUpCount(b_number);
	}
	public void thumbDownCountService(int b_number) {
		boardDao.thumbDownCount(b_number);
	}
}
