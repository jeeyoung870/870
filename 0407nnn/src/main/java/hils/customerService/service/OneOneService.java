package hils.customerService.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.customerService.model.AskAndReplyDto;
import hils.customerService.model.AskDto;
import hils.customerService.model.ReplyDto;

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
	public AskAndReplyDto selectAskAndReplyService(String user_id, int ask_num) {
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("user_id", user_id);
			paraMap.put("ask_num", ask_num);
			return oneOneDao.selectAskAndReply(paraMap);
		
	}
	public void insertNewReply(ReplyDto replyDto) {
		oneOneDao.writeNewReply(replyDto);
		oneOneDao.setIsReplied(replyDto.getAsk_num());
	}
	
}
