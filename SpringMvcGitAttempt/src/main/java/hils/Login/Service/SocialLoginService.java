package hils.Login.Service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialLoginService {

	private static final String NAMESPACE = "memberMapper";

	@Autowired
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public void email(String email) {
		sqlSession.insert(NAMESPACE + ".emailRegister", email);
	}

}
