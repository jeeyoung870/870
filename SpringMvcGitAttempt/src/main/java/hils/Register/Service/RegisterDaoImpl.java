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

	@Override
	public void register(RegisterDto regiDto) throws Exception {
		sql.insert("registerMapper.userRegister", regiDto);
	}

	@Override
	public void register2(RegisterDto regiDto) throws Exception {
		sql.insert("registerMapper.userRegister2", regiDto);
	}

	@Override
	public int idCheck(RegisterDto regiDto) throws Exception {
		int result = sql.selectOne("registerMapper.idCheck", regiDto);
		return result;
	}
	
	@Override
	public int emailCheck(RegisterDto regiDto) throws Exception {
		int result = sql.selectOne("registerMapper.emailCheck", regiDto);
		return result;
	}
}