package spring.bookstore;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class BookDao extends SqlSessionDaoSupport{
	/*
	@Autowired
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public List<BookDto> orderList1(String name) {
		return session.selectList("cust.orderList1", name); 
	}
	*/
	public List<BookDto> orderList1(String name) {
		return getSqlSession().selectList("cust.orderList1", name);
	}
	
	public List<OrderListDto> orderList2(int custid) {
		return getSqlSession().selectList("cust.orderList2", custid);
	}
	
	public int sumPrice(int custid) {
		return getSqlSession().selectOne("cust.sumPrice", custid);
	}
}
