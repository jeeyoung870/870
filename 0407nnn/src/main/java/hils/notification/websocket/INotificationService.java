package hils.notification.websocket;

import java.util.Date;
import java.util.List;

import hils.notification.model.GeneralNotiDto;

public interface INotificationService {
	public int insertNotiService(GeneralNotiDto notiDto);
	public int deleteNotiService(String user_id, Date noti_date, String noti_identifier);
	public List<GeneralNotiDto> selectUserNotiService(String user_id);
	public String checkThereisNoti(String user_id);
}
