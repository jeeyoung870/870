package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.model.BoardDto;

@Repository
public class BoardDao  {
	@Autowired
	SqlSession session;
	
	public int count() {
		return session.selectOne("board.count");
	}
	
	public void readCount(int num) {
		session.update("board.readcount",num);
	}
	
	public int selectMax() {
		return session.selectOne("board.max");
	}
	
	public String password(int num) {
		return session.selectOne("board.password",num);
	}
	
	public List<BoardDto> getList(int start,int end){
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("start",start);
		m.put("end",end);
		return session.selectList("board.list",m);
	}
	
	public BoardDto getContent(int num){
		return session.selectOne("board.one",num);
	}
	
	
	public void update(BoardDto dto) {
		session.update("board.update",dto);
	}
	
	public void updateRef(BoardDto dto) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("ref", dto.getRef());
		m.put("re_step",dto. getRe_step());
		session.update("board.update_ref", m);
	}
	
	public void delete(int num) {
		session.delete("board.delete",num);
	}
	

	public void insert(BoardDto dto) {
		session.insert("board.insert", dto);
	}

}
