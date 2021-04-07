package files.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.model.BoardDto;

@Repository
public class FBoardDao {
	
	@Autowired
	SqlSession session;
	
	public int count() {
		return session.selectOne("file.count");
	}
	
	public void readCount(int num) {
		session.update("file.readcount",num);
	}
	
	public int selectMax() {
		return session.selectOne("file.max");
	}
	
	public String password(int num) {
		return session.selectOne("file.password",num);
	}
	
	public List<BoardDto> getList(int start,int end){
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("start",start);
		m.put("end",end);
		return session.selectList("file.list",m);
	}
	
	public BoardDto getContent(int num){
		return session.selectOne("file.one",num);
	}
	
	
	public void update(BoardDto dto) {
		session.update("file.update",dto);
	}
	
	public void updateRef(BoardDto dto) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("ref", dto.getRef());
		m.put("re_step",dto. getRe_step());
		session.update("file.update_ref", m);
	}
	
	public void delete(int num) {
		session.delete("file.delete",num);
	}
	

	public void insert(BoardDto dto) {
		session.insert("file.insert", dto);
	}

}
