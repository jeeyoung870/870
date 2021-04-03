package hils.mypage2.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hils.manageCustomerService1.model.FAQManagementDto;
import hils.mypage2.model.MyActBoardDto;
import hils.mypage2.model.MyActCalendarDto;

@Component
public class MyActBoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int count() {
		return sqlSession.selectOne("myAct.count");
	}
	
	public List<MyActBoardDto> getMyActBoardlist(int start, int end, String category, String searchWord, String myActUserId) {
		Map <String, Object> m = new HashMap<String, Object>();
		m.put("start",start);
		m.put("end", end);
		m.put("category", category);
		m.put("searchWord", searchWord);
		m.put("myActUserId", myActUserId);
		return sqlSession.selectList("myAct.searchList",m);
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<MyActCalendarDto> getCalDataList(Map<String, Object> paraMap) {
		return sqlSession.selectList("myAct.selectCal", paraMap);
	}


}
