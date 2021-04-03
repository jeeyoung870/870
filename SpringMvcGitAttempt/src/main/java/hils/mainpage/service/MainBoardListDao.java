package hils.mainpage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hils.mainpage.model.MainBoardListDto;
import hils.manageCustomerService1.model.FAQManagementDto;
import hils.mypage2.model.MyActBoardDto;

@Component
public class MainBoardListDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int count() {
		return sqlSession.selectOne("mainPage.count");
	}
	
	public List<MainBoardListDto> getListMainBoardList(int start, int end) {
		Map <String, Object> m = new HashMap<String, Object>();
		m.put("start",start);
		m.put("end", end);
		return sqlSession.selectList("mainPage.searchList",m);
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<String> getListMainUserList(String main_bgndate, String main_enddate) {
		System.out.println(main_bgndate+"   "+main_enddate);
		Map <String, Object> m = new HashMap<String, Object>();
		m.put("main_bgndate",main_bgndate);
		m.put("main_enddate", main_enddate);
		return sqlSession.selectList("mainPage.searchUserList",m);
	}

}
