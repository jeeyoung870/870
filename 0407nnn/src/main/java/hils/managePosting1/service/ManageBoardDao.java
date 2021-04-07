package hils.managePosting1.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hils.community.model.BoardDto;
import hils.managePosting1.model.ManagerSearchVO;

@Repository
public class ManageBoardDao {

	private SqlSession sqlSession;
	
	public ManageBoardDao() {};
	@Autowired
	public ManageBoardDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<BoardDto> managerSearchBoard(ManagerSearchVO managerSearchVO){

		return sqlSession.selectList("manageBoard.searchArticle", managerSearchVO);
	}
	public void doManagerDeleteAritlce(int b_number) {
		sqlSession.delete("manageBoard.managerDeleteArticle", b_number);
	}
	public BoardDto selectBoardContent(int b_number) {
		return sqlSession.selectOne("board.selectSpecificContent",b_number );
	}
	public void doManagerUpdateArticle(BoardDto boardDto) {
		sqlSession.update("manageBoard.managerUpdateArticle", boardDto);
	}
}
