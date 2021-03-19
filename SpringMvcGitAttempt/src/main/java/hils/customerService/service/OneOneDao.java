package hils.customerService.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hils.customerService.model.AskDto;

@Component
public class OneOneDao {

	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public void writeNewOneOne(AskDto askDto) {
		sqlSession.insert("oneOne.newOneOneAsk", askDto);
	}
	public List<AskDto> selectAskList(String user_id){
		return sqlSession.selectList("oneOne.selectAskList", user_id);
	}
}
