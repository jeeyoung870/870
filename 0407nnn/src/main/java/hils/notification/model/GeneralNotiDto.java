package hils.notification.model;

import java.util.Date;

public class GeneralNotiDto {
	private String user_id;
	private Date noti_date;
	private String noti_content;
	private String noti_identifier;
	
	
	public String getNoti_identifier() {
		return noti_identifier;
	}
	public void setNoti_identifier(String noti_identifier) {
		this.noti_identifier = noti_identifier;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getNoti_date() {
		return noti_date;
	}
	public void setNoti_date(Date noti_date) {
		this.noti_date = noti_date;
	}
	public String getNoti_content() {
		return noti_content;
	}
	public void setNoti_content(String noti_content) {
		this.noti_content = noti_content;
	}
	
}	
