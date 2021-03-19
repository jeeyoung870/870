package hils.managemainpage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.managemainpage.model.FileDto;

@Service
public class FileService {

	@Autowired
	FileDao dao;

	public void addFile(String origName, String path) {
		dao.deleteFile();
		FileDto dto = new FileDto(0, origName, path);
		int x = dao.addFile(dto);
		
		if(x == 0) {
			System.out.println("addFile fail!!");
		}else {
			System.out.println("addFile seccess!!");
		}
	}
	
	
/*
 * 	public void imgModify(String origName, String path, int no) {
		FileDto dto = new FileDto(no, origName, path);
		int x = dao.addFile(dto);
		
		if(x == 0) {
			System.out.println("imgModify fail!!");
		}else {
			System.out.println("imgModify seccess!!");
		}
	}*/
	
	public void setDao(FileDao dao) {
		this.dao = dao;
	}



	
	
	
}
