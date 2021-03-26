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
}
