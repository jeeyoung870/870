package hils.Report.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hils.Report.Model.PagingDto;
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

	// 신고글 작성
	public void writeMethod(ReportDto write) {
		System.out.println("신고글 작성 쿼리 실행");
		sql.insert(Namespace + ".writeReport", write);
	}

	// 신고글 삭제
	public void deleteMethod(String delete) {
		sql.delete(Namespace + ".deleteReport", delete);
	}
	
	// 신고글 목록 갯수 확인
	public int countBoard() {
		int result = sql.selectOne(Namespace + ".countReport");
		return result;
	}
	
	// 신고글 조회
	public List<ReportDto> selectReportBoard(PagingDto pDto) throws Exception {
		return sql.selectList(Namespace + ".selectReportBoard", pDto);
	}
	
}
