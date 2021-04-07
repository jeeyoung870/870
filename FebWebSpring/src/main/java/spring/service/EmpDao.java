package spring.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.DeptDto;
import spring.model.EmpDto;

@Repository  //DAO : data access object
public class EmpDao {
	
	@Autowired
	SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<DeptDto> selectDepts(){
		return session.selectList("scott.depts");
	}
	public List<Map<String,Object>> selectEmps(int deptno){
		return session.selectList("scott.emps", deptno);
	}
	public EmpDto selectEmpOne(int empno){
		return session.selectOne("scott.empOne", empno);
	}
}
