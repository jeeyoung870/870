package dept.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import dept.dto.DeptDto;
import dept.dto.EmpDto;
//Mapper xml���� ��� ����� �� �ִ� interface
public interface DeptMapper {
	//�߻�޼ҵ忡 @������̼��� ���̸�, �ش� sql���� ������ �� �ִ� �޼ҵ�� �������̵���.
	@Select("Select * from dept")
	public List<DeptDto> findDepts();
	
	@Select("Select * from dept where deptno = #{deptno}")
	public DeptDto findDept(int deptno);
	
	@Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")
	public int addDept(DeptDto dto);
	
	//foreach���� �� select��
	@Select({"<script>",
		"select * from emp where empno in ",
  		"<foreach item='item' index='index' collection='array' open='(' separator=',' close=')'> #{item} </foreach>","</script>"})
	public List<EmpDto> emps(Map<String , Object> map);

	

}
