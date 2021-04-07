package dept.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.dto.EmpDto;


public class EmpDao {
	public List<EmpDto> empFind(String ename) {
		List<EmpDto> empList = null;
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();	
		empList = session.selectList("emp.findEmp", ename); 
		session.close();
		return empList;
	}
	
	public List<EmpDto> empnoFind(int empno) {
		List<EmpDto> empList = null;
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();	
		empList = session.selectList("emp.findEmpno", empno); 
		session.close();
		return empList;
	}
	
	public int count() {
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int x = session.selectOne("emp.count");
		session.close();
		return x;
	}
}
