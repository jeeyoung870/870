package hils.Report.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hils.Report.Model.ReportDto;

@Repository
public class ReportDao {

	@Autowired
	private SqlSession sql;

	public SqlSession getSql() {
		return sql;
	}

	public void setSql(SqlSession sql) {
		this.sql = sql;
	}

	private static final String Namespace = "reportMapper";

	// 여러개의 데이터를 가져오게 되므로 List로 받아서 가져옴.
	public List<ReportDto> selectReport() throws Exception {
		return sql.selectList(Namespace + ".reportSelect");
	}

	// 입력메서드 확인할것
	public void insertMethod(Map<String, Object> map) {
		sql.insert(Namespace + ".reportInsert", map);
	}
	
	// 게시물 삭제
	public void deleteMethod(String delete) {
		sql.delete(Namespace + ".deleteReport", delete);
	}
}
