package hils.manageCustomerService1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.manageCustomerService1.model.FAQManagementDto;
import hils.manageCustomerService1.model.FAQManagementListModel;

@Service
public class FAQManagementService {

	@Autowired
	private FAQManagementDao dao;
	
	/*public FAQManagementListModel list(int pageNum, int per) {
		int count = dao.count();
		if (count == 0) {
			return new FAQManagementListModel();
		}

		int start = (pageNum - 1) * per + 1;
		int end = start * per;
		List<FAQManagementDto> list = dao.getList(start, end);

		ManagementPaging p = new ManagementPaging().paging(pageNum, count, per);

		return new FAQManagementListModel(list, pageNum, p.totalPageCount, start, p, count);
	}*/
		
	public FAQManagementListModel faqManageSearchBoardlist(int pageNum, int per, String category, String searchWord) {
		int count = dao.count();
		if (count == 0) {
			return new FAQManagementListModel();
		}

		int start = (pageNum - 1) * per + 1;
		int end = start * per;
		
		List<FAQManagementDto> list = dao.getSearchList(start, end,category,searchWord);

		ManagementPaging p = new ManagementPaging().paging(pageNum, count, per);

		return new FAQManagementListModel(list, pageNum, p.totalPageCount, start, p, count);
	}
	
	public FAQManagementDto getContent(int num) {
		return dao.getContent(num);
	}
	
	public void insert(FAQManagementDto dto) {
		int num = dto.getNum();
		dao.insert(dto);
	}
	
	public FAQManagementDto updateForm(int num) {
		return dao.getContent(num);
	}
	
	public void update(FAQManagementDto dto) {
		dao.update(dto);
	}
	
	public void delete(int num) {
		dao.delete(num);
	}

	
	public void setDao(FAQManagementDao dao) {
		this.dao = dao;
	}
	

	

}