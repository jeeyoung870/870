package hils.Login.Service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialLoginService {

	private static final String NAMESPACE = "registerMapper";

	@Autowired
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public void email(String user_email) {
		sqlSession.insert(NAMESPACE + ".emailRegister", user_email);
	}
	
	public void email2(String user_email) {
		sqlSession.insert(NAMESPACE + ".emailRegister2", user_email);
	}

}
