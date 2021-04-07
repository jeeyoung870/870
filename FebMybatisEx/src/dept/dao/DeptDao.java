package dept.dao;

import java.io.*;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dept.dto.DeptDto;

public class DeptDao {
	
	/*
	public int insertDept(DeptDto dto) {
		
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		//deptMapper.xml에 매핑된 mapper명과 insert태그의 id로 가져옴
		int x = session.insert("dept.addDept", dto);
		
		session.commit();
		session.close();
		return x;
	}
	*/
	public int insertDept(DeptDto dto) {
		
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		//deptMapper.xml에 매핑된 mapper명과 insert태그의 id로 가져옴
		int x = session.getMapper(DeptMapper.class).addDept(dto);  
		
		session.commit();
		session.close();
		return x;
	}
	
	
	public int updateLoc(int deptno, String loc) {
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		//입력받은 인자로 해시맵 객체 만들기
		HashMap<String, Object> map = new HashMap<>();
		map.put("deptno", deptno);
		map.put("loc", loc);
		
		int x = session.update("dept.modifyDept", map);
		
		session.commit();
		session.close();
		return x;
	}
	
	
	public int deleteDept(int deptno) {
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int x = session.delete("dept.delDept", deptno);
		session.commit();
		session.close();
		return x;
	}
	
	
	public int count() {
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int x = session.selectOne("dept.count");
		session.close();
		return x;
	}
	
	/*
	public List<DeptDto> deptAll() {
		List<DeptDto> deptList = null;
		//SqlSessionFactoryMaker.java클래스에서 config.xml를 사용해 db연결하는 객체를 간단하게 꺼내쓸수있다.
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();	//()안을 채우지 않으면 config에서 default로 지정된 environment사용
		//SqlSession : sql문을 실행할 수 있는 메소드를 가지고 있음
		//insert(), update(), delete() 
		//select문 : selectOne() - 하나 가져오기, selectList() - 여러개 가져오기
		//사용법 : selectList("deptMapper.xml파일에 설정한 namespace.id");
		deptList = session.selectList("dept.deptAll"); 
		session.close();
		return deptList;
	}
	*/
	
	public List<DeptDto> deptAll() {
		List<DeptDto> deptList = null;
		//SqlSessionFactoryMaker.java클래스에서 config.xml를 사용해 db연결하는 객체를 간단하게 꺼내쓸수있다.
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();	//()안을 채우지 않으면 config에서 default로 지정된 environment사용
		//SqlSession : sql문을 실행할 수 있는 메소드를 가지고 있음
		//insert(), update(), delete() 
		//select문 : selectOne() - 하나 가져오기, selectList() - 여러개 가져오기
		//사용법 : selectList("deptMapper.xml파일에 설정한 namespace.id");
		deptList = session.getMapper(DeptMapper.class).findDepts(); 
		session.close();
		return deptList;
	}
	
	
	
}
