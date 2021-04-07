package spring.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Setter;

public class MemDao extends SqlSessionDaoSupport {
	//sqlSession타입의 변수와 getter/setter를 상속받음
	//상속받은 경우에는 어노테이션을 붙일수 없으므로 bean태그를 만들어줘야 함.
	//selectList("namespace.id");
	public List<MemDto> selectMems() {
		return getSqlSession().selectList("mem.members");
	}
	
	public List<MemDto> insertMem(MemDto dto) {
		return getSqlSession().selectList("mem.addMem", dto);
	}
}

/*  어노테이션을 사용하는 경우
@Repository
public class MemDao {
	
	@Setter
	@Autowired
	SqlSession session;
	
	public List<MemDto> selectMems() {
		return session.selectList("mem.members");
	}

}
*/
