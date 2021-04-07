package files.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import files.model.FileDto;

//FBoardService에 합쳐짐
@Service
public class FileService {

	@Autowired
	FileDao dao;

	public void addFile(String origName, String path) {
		FileDto dto = new FileDto(0, origName, path);
		int x = dao.addFile(dto);
		
		if (x == 0) {
			System.out.println("insert fail");
		}else {
			System.out.println("insert success");
		}
	}
	
	
	public void setDao(FileDao dao) {
		this.dao = dao;
	}
	
	
	
}
