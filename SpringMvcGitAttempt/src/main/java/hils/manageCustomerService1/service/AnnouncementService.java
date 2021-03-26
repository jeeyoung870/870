package hils.manageCustomerService1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.manageCustomerService1.model.AnnouncementDto;

@Service("announcementService")
public class AnnouncementService implements IAnnouncementService {

	private AnnouncementDao announcementDao;
	
	public AnnouncementService() {};
	@Autowired
	public AnnouncementService(AnnouncementDao announcementDao) {
		this.announcementDao = announcementDao;
	}
	public void newAnnouncementService(AnnouncementDto announcementDto) {
		announcementDao.newAnnouncement(announcementDto);
	}
	public int countTotalAnnouService() {
		return announcementDao.countTotalAnnou();
	}
	public List<AnnouncementDto> searchAnnouService(String searchKeyword, String searchOption){
		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("searchOption", searchOption);
		paraMap.put("searchKeyword", searchKeyword);
		
		return announcementDao.searchAnnou(paraMap);
	}
	public AnnouncementDto selectAnnouService(int annou_writing_num) {
		return announcementDao.selectAnnou(annou_writing_num);
	}
	public void deleteAnnou(int annou_writing_num) {
		announcementDao.deleteAnnou(annou_writing_num);
	}
	public void updateAnnou(String subject, String content, int annou_writing_num) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("content", content);
		paraMap.put("subject", subject);
		paraMap.put("annou_writing_num", annou_writing_num);
		
		announcementDao.updateAnnou(paraMap);
	}
}
