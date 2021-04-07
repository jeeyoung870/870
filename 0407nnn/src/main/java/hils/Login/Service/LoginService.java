package hils.Login.Service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	private static final String NAMESPACE = "loginMapper";

	@Autowired
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	public void lastLoginUpdate(String user_id) {
		sqlSession.update(NAMESPACE + ".lastLoginUpdate", user_id);
	}
	
}
