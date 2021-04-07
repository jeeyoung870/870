package dept.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import dept.dto.DeptDto;
import dept.dto.EmpDto;
//Mapper xml문서 대신 사용할 수 있는 interface
public interface DeptMapper {
	//추상메소드에 @어노테이션을 붙이면, 해당 sql문을 실행할 수 있는 메소드로 오버라이딩됨.
	@Select("Select * from dept")
	public List<DeptDto> findDepts();
	
	@Select("Select * from dept where deptno = #{deptno}")
	public DeptDto findDept(int deptno);
	
	@Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")
	public int addDept(DeptDto dto);
	
	//foreach문이 들어간 select문
	@Select({"<script>",
		"select * from emp where empno in ",
  		"<foreach item='item' index='index' collection='array' open='(' separator=',' close=')'> #{item} </foreach>","</script>"})
	public List<EmpDto> emps(Map<String , Object> map);

	

}
