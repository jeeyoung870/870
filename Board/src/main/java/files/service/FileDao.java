package files.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import files.model.FileDto;

@Repository
public class FileDao {
	
	@Autowired
	SqlSession session;
	
	public int addFile(FileDto dto) {
		return session.insert("file.addFile", dto);
	}
	
	public List<FileDto> showFile(int num) {
		return session.selectList("file.showFile", num);
	}
	
	public String findPath(int no) {
		return session.selectOne("file.findPath", no);
	}

	public String findOrigName(int no) {
		return session.selectOne("file.findOrigName", no);
	}
	
	
	
	
	
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	
	
}
