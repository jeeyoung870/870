package hils.notification.websocket;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.notification.model.GeneralNotiDto;

@Service("notificationService")
public class NotificationService implements INotificationService {

	@Autowired
	private NotificationDao notificationDao;
	
	public void setNotificationDao(NotificationDao notificationDao) {
		this.notificationDao = notificationDao;
	}

	@Override
	public int insertNotiService(GeneralNotiDto notiDto) {
		// TODO Auto-generated method stub
		return notificationDao.insertNoti(notiDto);
	}

	@Override
	public int deleteNotiService(String user_id, Date noti_date, String noti_identifier) {
		// TODO Auto-generated method stub
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("user_id", user_id);
		
		int result = -1;
		
		if(noti_date == null) {
			
		}else {
			paraMap.put("noti_date", noti_date);
			
		}
		if(noti_identifier == null) {
			
		}else {
			paraMap.put("noti_identifier",noti_identifier);
		}
		result = notificationDao.deleteNoti(paraMap);
		
		
		////////result
		if(result == 0) {
			System.out.println("deletion failed");
		}else {
			System.out.println("success : " + result);
		}
		return result;
	}

	@Override
	public List<GeneralNotiDto> selectUserNotiService(String user_id) {
		// TODO Auto-generated method stub
		return notificationDao.selectUserNoti(user_id);
	}
	public String checkThereisNoti(String user_id) {
		return notificationDao.checkThereisNoti(user_id);
	}
}
