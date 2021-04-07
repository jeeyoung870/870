package download.upload;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import download.upload.FileDto;

@Repository
public class FileDao {
	
	@Autowired
	SqlSession session;
	
	public int addFile(FileDto dto) {
		return session.insert("file.addFile", dto);
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	
	
}
