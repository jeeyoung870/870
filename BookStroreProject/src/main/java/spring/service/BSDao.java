package spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.customDto;
import spring.model.salesDto;


@Repository
public class BSDao {
	@Autowired
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public List<customDto> allCust() {
		return session.selectList("BS.allCust");
	}
	
	public List<salesDto> bookSales(String bookname){
		return session.selectList("BS.bookSales", bookname);
	}
	
	public List<salesDto> customSales1(String name) {
		return session.selectList("BS.customSales1", name);
	}
	public List<salesDto> customSales2(String name) {
		return session.selectList("BS.customSales2", name);
	}
	
	public int newCustid() {
		return session.selectOne("BS.newCustid");
	}
	
	public int insertCust(customDto custDto) {
		return session.insert("BS.insertCust", custDto);
	}
	
	public int updateAddr(customDto custDto) {
		return session.update("BS.updateAddr", custDto);
	}
	

}
