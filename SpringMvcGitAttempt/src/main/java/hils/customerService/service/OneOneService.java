package hils.customerService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.customerService.model.AskDto;

@Service
public class OneOneService {

	@Autowired
	private OneOneDao oneOneDao;

	public void setOneOneDao(OneOneDao oneOneDao) {
		this.oneOneDao = oneOneDao;
	}
	public void writeNewOneOneService(AskDto askDto) {
		oneOneDao.writeNewOneOne(askDto);
	}
	public List<AskDto> selectAskListService(String user_id){
		return oneOneDao.selectAskList(user_id);
	}
}
