package spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.DeptDto;
import spring.model.EmpDto;

@Service
public class EmpService {
	@Autowired
	EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	
	public List<DeptDto> selectDepts(){
		return dao.selectDepts();
	}
	public List<Map<String,Object>> selectEmps(int deptno){
		return dao.selectEmps(deptno);
	}
	public EmpDto selectEmpOne(int empno){
		return dao.selectEmpOne(empno);
	}
	
}