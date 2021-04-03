package hils.manageCustomerService1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.customerService.model.AskDto;
import hils.manageCustomerService1.model.AskAndReplyDto;

@Service("oneVOneManageService")
public class OneVOneManageService implements IOneOneManageService {

	
	private OneVOneDao oneVOneDao;
	
	public OneVOneManageService() {};
	
	@Autowired
	public OneVOneManageService(OneVOneDao oneVOneDao) {
		this.oneVOneDao = oneVOneDao;
	}
	
	
	@Override
	public List<AskDto> getAskListService(int ask_start_num, int ask_end_num) {
		// TODO Auto-generated method stub
		Map<String, Integer> paraMap = new HashMap<String, Integer>();
		paraMap.put("ask_start_num", ask_start_num);
		paraMap.put("ask_end_num", ask_end_num);
		return oneVOneDao.getAskList(paraMap);
	}
	public AskAndReplyDto getAskAndReplyService(int ask_num){
		return oneVOneDao.getAskAndReply(ask_num);
	}
	public int getTotalAskCount() {
		return oneVOneDao.selectTotalAskCount();
	}
	
}
