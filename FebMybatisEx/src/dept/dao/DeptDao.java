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
		//deptMapper.xml�� ���ε� mapper��� insert�±��� id�� ������
		int x = session.insert("dept.addDept", dto);
		
		session.commit();
		session.close();
		return x;
	}
	*/
	public int insertDept(DeptDto dto) {
		
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		//deptMapper.xml�� ���ε� mapper��� insert�±��� id�� ������
		int x = session.getMapper(DeptMapper.class).addDept(dto);  
		
		session.commit();
		session.close();
		return x;
	}
	
	
	public int updateLoc(int deptno, String loc) {
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		//�Է¹��� ���ڷ� �ؽø� ��ü �����
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
		//SqlSessionFactoryMaker.javaŬ�������� config.xml�� ����� db�����ϴ� ��ü�� �����ϰ� ���������ִ�.
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();	//()���� ä���� ������ config���� default�� ������ environment���
		//SqlSession : sql���� ������ �� �ִ� �޼ҵ带 ������ ����
		//insert(), update(), delete() 
		//select�� : selectOne() - �ϳ� ��������, selectList() - ������ ��������
		//���� : selectList("deptMapper.xml���Ͽ� ������ namespace.id");
		deptList = session.selectList("dept.deptAll"); 
		session.close();
		return deptList;
	}
	*/
	
	public List<DeptDto> deptAll() {
		List<DeptDto> deptList = null;
		//SqlSessionFactoryMaker.javaŬ�������� config.xml�� ����� db�����ϴ� ��ü�� �����ϰ� ���������ִ�.
		SqlSessionFactory factory = SqlSessionFactoryMaker.getSqlSessionFactory();
		
		SqlSession session = factory.openSession();	//()���� ä���� ������ config���� default�� ������ environment���
		//SqlSession : sql���� ������ �� �ִ� �޼ҵ带 ������ ����
		//insert(), update(), delete() 
		//select�� : selectOne() - �ϳ� ��������, selectList() - ������ ��������
		//���� : selectList("deptMapper.xml���Ͽ� ������ namespace.id");
		deptList = session.getMapper(DeptMapper.class).findDepts(); 
		session.close();
		return deptList;
	}
	
	
	
}
