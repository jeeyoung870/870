package hils.manageintro.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntroService {

	@Autowired
	private IntroDao dao;
	
	
	public Map<String,Integer> subscriberStatistics() {
		return dao.subscriberStatistics();
	}
	
	public void setDao(IntroDao dao) {
		this.dao = dao;
	}


	

	

}