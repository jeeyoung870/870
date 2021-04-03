package hils.community.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hils.community.model.BoardDto;
import hils.community.model.LikeThumbDto;
import hils.community.model.SubBoardDto;

@Component
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<BoardDto> selectBoardList(HashMap<String, Object> paraMap) {
		return sqlSession.selectList("board.selectBoardList", paraMap);
	}
	public int checkTotalArticleCount() {
		return sqlSession.selectOne("board.checkTotalArticleCount");
	}
	public void insertNewArticle(BoardDto boardDto) {
		sqlSession.insert("board.insertNewArticle", boardDto);
	}
	public BoardDto selectSpecificContent(int b_number) {
		return sqlSession.selectOne("board.selectSpecificContent", b_number);
	}
	public List<BoardDto> selectSpecificCategory(String b_category){
		return sqlSession.selectList("board.selectCategory", b_category);
	}
	public void updateArticle(HashMap<String, Object> paraMap) {
		sqlSession.update("board.updateArticle", paraMap);
	}
	public void readcountUp(int b_number) {
		sqlSession.update("board.readcountUp", b_number);
	}
	            
	//subBoard
	public List<SubBoardDto> selectSpecificSubBoardList(int b_number){
		return sqlSession.selectList("board.selectSubArticleList", b_number);
	}
	public int selectCommentNumber() {
		return sqlSession.selectOne("board.selectCommentNumber");
	}
	public void insertNewComment(SubBoardDto subBoardDto) {
		sqlSession.insert("board.insertNewComment", subBoardDto);
	}
	//noti
	public String selectBoardSubject(int b_number) {
		return sqlSession.selectOne("noti.selectBoardSubject", b_number);
	}
	//like Thumb
	public void newLikeThumb(LikeThumbDto likeDto) {
		sqlSession.insert("board.newLike", likeDto);
	}
	public String isLikeThumbed(LikeThumbDto likeDto) {
		return sqlSession.selectOne("board.isThumb", likeDto);
	}
	public void cancelThumb(LikeThumbDto likeDto) {
		sqlSession.delete("board.cancelThumb", likeDto);
	}
	public void thumbUpCount(int b_number) {
		sqlSession.update("board.thumbUp", b_number);
	}
	public void thumbDownCount(int b_number) {
		sqlSession.update("board.thumbDown", b_number);
	}
}
