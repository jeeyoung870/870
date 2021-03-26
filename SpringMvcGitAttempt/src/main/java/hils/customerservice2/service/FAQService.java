package hils.customerservice2.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.customerservice2.model.FAQDto;
import hils.customerservice2.model.FAQListModel;

@Service
public class FAQService {

	@Autowired
	private FAQDao dao;
	
/*
 * 	public FAQListModel faqViewList(int pageNum, int per) {
		int count = dao.count();
		if (count == 0) {
			return new FAQListModel();
		}

		int start = (pageNum - 1) * per + 1;
		int end = start * per;
		List<FAQDto> list = dao.getList(start, end);

		Paging p = new Paging().paging(pageNum, count, per);

		return new FAQListModel(list, pageNum, p.totalPageCount, start, p, count);
	}
 * */
	
	public FAQListModel faqViewListCategory(int pageNum, int per, String category) {
		int count = dao.getPagingCategory(category);
		if (count == 0) {
			return new FAQListModel();
		}

		int start = (pageNum - 1) * per + 1;
		int end = start * per;
		List<FAQDto> list = dao.getListCategory(start, end, category);

		Paging p = new Paging().paging(pageNum, count, per);

		return new FAQListModel(list, pageNum, p.totalPageCount, start, p, count);
	}
	
	public List<FAQDto> selectFaqListService(int start, int end, String category){
		HashMap <String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("category", category);
		paraMap.put("start_writing_num", start);
		paraMap.put("end_writing_num", end);
		return dao.selectFaqList(paraMap);
	}
	
	public FAQDto getContent(int num) {
		return dao.getContent(num);
	}
	
	public void setDao(FAQDao dao) {
		this.dao = dao;
	}

	public int getPagingCategory(String category) {
		return dao.getPagingCategory(category);
	}

	
	
	

}