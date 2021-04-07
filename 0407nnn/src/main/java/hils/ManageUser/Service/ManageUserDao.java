package hils.ManageUser.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hils.Register.Model.RegisterDto;
import hils.Report.Model.PagingDto;
import hils.Report.Model.ReportDto;

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
	
	// DB에서 회원 삭제 (강제탈퇴)
	public void deleteMethod(String delete) {
		sql.delete(Namespace + ".userDelete", delete);
	}

	public void dormancyMethod(RegisterDto user_id) {
		sql.update(Namespace + ".userDormancy", user_id);
	}
	
	public void dormancyCancleMethod(RegisterDto user_id) {
		sql.update(Namespace + ".userDormancyCancle", user_id);
	}
	
	// 회원 목록 갯수 확인
	public int countMethod() {
		int result = sql.selectOne(Namespace + ".UserCount");
		return result;
	}
	
	// 회원 조회
	public List<RegisterDto> selectUserMethod(PagingDto registerPagingDto) throws Exception {
		return sql.selectList(Namespace + ".UserSelect", registerPagingDto);
	}
}
