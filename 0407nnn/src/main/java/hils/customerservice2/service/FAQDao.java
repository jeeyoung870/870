package hils.customerservice2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hils.community.model.BoardDto;
import hils.customerservice2.model.FAQDto;

@Component
public class FAQDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int count() {
		return sqlSession.selectOne("faq.count");
	}
	
	public List<FAQDto> getList(int start, int end){
		Map <String, Integer> m = new HashMap<String, Integer>();
		m.put("start",start);
		m.put("end", end);
		return sqlSession.selectList("faq.faqViewList",m);
	}
	
	public FAQDto getContent(int num) {
		return sqlSession.selectOne("faq.viewOne",num);
	}
	
	/*카테고리 분류*/
	public List<FAQDto> selectFaqList(HashMap<String, Object> paraMap) {
		return sqlSession.selectList("faq.selectFaqList", paraMap);
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<FAQDto> getListCategory(int start, int end, String category) {
		Map <String, Object> m = new HashMap<String, Object>();
		m.put("start",start);
		m.put("end", end);
		m.put("category", category);
		return sqlSession.selectList("faq.faqViewListCategory",m);
	}

	public int getPagingCategory(String category) {
		return sqlSession.selectOne("faq.getPagingCategory",category);
	}
	
}
