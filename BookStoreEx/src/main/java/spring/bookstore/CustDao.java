package spring.bookstore;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CustDao extends SqlSessionDaoSupport {
	public List<CustDto> selectCusts() {
		return getSqlSession().selectList("cust.allCust");
	}
	
	public int insertCust(CustDto dto) {
		System.out.println(dto);
		return getSqlSession().insert("cust.addCust", dto);
	}

}
