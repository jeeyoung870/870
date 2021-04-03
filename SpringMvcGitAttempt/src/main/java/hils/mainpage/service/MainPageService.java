package hils.mainpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.mainpage.model.MainBoardListDto;
import hils.mainpage.model.MainBoardListModel;

@Service
public class MainPageService {
	@Autowired
	private MainBoardListDao dao;
	
	public MainBoardListModel mianBoardlist(int pageNum, int per) {
		int count = dao.count();
		if (count == 0) {
			return new MainBoardListModel();
		}

		int start = (pageNum - 1) * per + 1;
		int end = start * per;
		
		List<MainBoardListDto> list = dao.getListMainBoardList(start, end);

		MainBoardListPaging p = new MainBoardListPaging().paging(pageNum, count, per);

		return new MainBoardListModel(list, pageNum, p.totalPageCount, start, p, count);
	}

	public void setDao(MainBoardListDao dao) {
		this.dao = dao;
	}

	public List<String> mainUserlist(String main_bgndate, String main_enddate) {
		return dao.getListMainUserList(main_bgndate, main_enddate);
	}
	
}
