package hils.footer.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FooterDao {
	@Autowired
	SqlSession session;

	public List<FooterDto> selectInfo(){
		return session.selectList("footer.cInfo");
	}
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

}
