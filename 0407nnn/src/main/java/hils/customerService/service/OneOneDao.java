package hils.customerService.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hils.customerService.model.AskAndReplyDto;
import hils.customerService.model.AskDto;
import hils.customerService.model.ReplyDto;

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
	public AskAndReplyDto selectAskAndReply(Map<String, Object> paraMap) {
		return sqlSession.selectOne("oneOne.selectAskAndReply", paraMap);
	}
	public void writeNewReply(ReplyDto replyDto) {
		sqlSession.insert("oneOne.newReply", replyDto);
	}
	public void setIsReplied(int ask_num) {
		sqlSession.update("oneOne.updateReplied", ask_num);
	}
}
