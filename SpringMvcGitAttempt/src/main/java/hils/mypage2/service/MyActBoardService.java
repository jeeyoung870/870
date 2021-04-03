package hils.mypage2.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.mypage2.model.MyActBoardDto;
import hils.mypage2.model.MyActBoardListModel;
import hils.mypage2.model.MyActCalendarDto;

@Service
public class MyActBoardService {
	@Autowired
	private MyActBoardDao dao;
	
	public MyActBoardListModel myActBoardlist(int pageNum, int per, String category, String searchWord, String myActUserId) {
		int count = dao.count();
		if (count == 0) {
			return new MyActBoardListModel();
		}

		int start = (pageNum - 1) * per + 1;
		int end = start * per;
		
		List<MyActBoardDto> list = dao.getMyActBoardlist(start, end,category,searchWord,myActUserId);

		MyActBoardPaging p = new MyActBoardPaging().paging(pageNum, count, per);

		return new MyActBoardListModel(list, pageNum, p.totalPageCount, start, p, count);
	}

	public void setDao(MyActBoardDao dao) {
		this.dao = dao;
	}

	public List<MyActCalendarDto> getCalDataListService(String user_id, Date input_date) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("user_id", user_id);
		paraMap.put("input_date", input_date);
		return dao.getCalDataList(paraMap);
	}

}
