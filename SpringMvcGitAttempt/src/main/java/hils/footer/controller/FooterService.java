package hils.footer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooterService {
	@Autowired
	FooterDao dao;
	
	public List<FooterDto> selectInfo(){
		return dao.selectInfo();
	}

}
