package hils.manageintro.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntroDao {
	@Autowired
	private SqlSession sqlSession;
	
	public Map<String,Integer> subscriberStatistics() {
		return sqlSession.selectOne("manageIntro.subscriberStatistics");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


}
