package hils.manageCustomerService1.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hils.customerService.model.AskDto;
import hils.manageCustomerService1.model.AskAndReplyDto;

@Repository
public class OneVOneDao {
	
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<AskDto> getAskList(Map<String, Integer> paraMap){
		return sqlSession.selectList("manageCustService.selectAskList", paraMap);
	}
	public AskAndReplyDto getAskAndReply(int ask_num){
		return sqlSession.selectOne("manageCustService.selectAskAndReply", ask_num);
	}
	public int selectTotalAskCount() {
		return sqlSession.selectOne("manageCustService.selectTotalAskCount");
	}
}
