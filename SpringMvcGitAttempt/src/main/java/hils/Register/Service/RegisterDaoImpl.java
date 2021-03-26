package hils.Register.Service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hils.Register.Model.RegisterDto;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private SqlSession sql;

	public SqlSession getSql() {
		return sql;
	}

	public void setSql(SqlSession sql) {
		this.sql = sql;
	}
	
	public void register(RegisterDto regiDto) throws Exception {
		sql.insert("registerMapper.userRegister", regiDto);
	}
}