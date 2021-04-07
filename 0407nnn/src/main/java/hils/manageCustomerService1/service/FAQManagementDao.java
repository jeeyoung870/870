package hils.manageCustomerService1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hils.manageCustomerService1.model.FAQManagementDto;

@Component
public class FAQManagementDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int count() {
		return sqlSession.selectOne("faq.count");
	}
	
	/*public List<FAQManagementDto> getList(int start, int end){
		Map <String, Integer> m = new HashMap<String, Integer>();
		m.put("start",start);
		m.put("end", end);
		return sqlSession.selectList("faq.list",m);
	}*/
	
	public List<FAQManagementDto> getSearchList(int start, int end, String category, String searchWord) {
		Map <String, Object> m = new HashMap<String, Object>();
		m.put("start",start);
		m.put("end", end);
		m.put("category", category);
		m.put("searchWord", searchWord);
		return sqlSession.selectList("faq.searchList",m);
	}
	
	public void insert(FAQManagementDto dto) {
		sqlSession.insert("faq.insert", dto);
	}
	
	public FAQManagementDto getContent(int num) {
		return sqlSession.selectOne("faq.one",num);
	}
	
	public void update(FAQManagementDto dto) {
		sqlSession.update("faq.update",dto);
	}
	
	public void delete(int num) {
		sqlSession.delete("faq.delete",num);
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


}
