package hils.ManageUser.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hils.Register.Model.RegisterDto;

@Repository
public class ManageUserDao {

	@Autowired
	private SqlSession sql;

	public SqlSession getSql() {
		return sql;
	}

	public void setSql(SqlSession sql) {
		this.sql = sql;
	}

	private static final String Namespace = "manageUserMapper";

	// 여러개의 데이터를 가져오게 되므로 List로 받아서 가져옴.
	public List<RegisterDto> selectMethod() throws Exception {
		return sql.selectList(Namespace + ".userSelect");
	}

	// DB에서 회원 삭제 (강제탈퇴)
	public void deleteMethod(String delete) {
			sql.delete(Namespace + ".userDelete", delete);
	}
}
