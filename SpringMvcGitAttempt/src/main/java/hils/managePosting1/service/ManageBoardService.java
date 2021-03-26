package hils.managePosting1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.community.model.BoardDto;
import hils.managePosting1.model.ManagerSearchVO;

@Service("manageBoardService")
public class ManageBoardService implements IManageBoardService {

	private ManageBoardDao manageBoardDao;
	
	public ManageBoardService () {};
	
	@Autowired
	public ManageBoardService(ManageBoardDao manageBoardDao) {
		this.manageBoardDao = manageBoardDao;
	}
	public List<BoardDto> managerSearchBoardService(ManagerSearchVO managerSearchVO){
		return manageBoardDao.managerSearchBoard(managerSearchVO);
	}
}
