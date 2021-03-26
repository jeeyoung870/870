package hils.manageCustomerService1.service;

import java.util.List;

import hils.customerService.model.AskDto;
import hils.manageCustomerService1.model.AskAndReplyDto;

public interface IOneVOneService {
	public List<AskDto> getAskListService(int ask_start_num, int ask_end_num);
	public int getTotalAskCount();
	public AskAndReplyDto getAskAndReplyService(int ask_num);
}
