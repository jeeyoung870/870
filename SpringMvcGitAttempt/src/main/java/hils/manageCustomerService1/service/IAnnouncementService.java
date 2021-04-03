package hils.manageCustomerService1.service;

import java.util.List;

import hils.manageCustomerService1.model.AnnouncementDto;

public interface IAnnouncementService {
	public void newAnnouncementService(AnnouncementDto announcementDto);
	public int countTotalAnnouService();

	public List<AnnouncementDto> searchAnnouService(String searchKeyword, String searchOption);
	public AnnouncementDto selectAnnouService(int annou_writing_num);
	public void deleteAnnou(int annou_writing_num);
	public void updateAnnou(String subject, String content, int annou_writing_num);

	//user
	public List<AnnouncementDto> userAnnouListService(int start_annou_num, int end_annou_num);
}
