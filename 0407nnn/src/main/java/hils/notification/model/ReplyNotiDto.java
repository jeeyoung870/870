package hils.notification.model;

import java.util.Date;

public class ReplyNotiDto {
	private String user_id;
	private String ask_subject;
	private Date reply_date;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAsk_subject() {
		return ask_subject;
	}
	public void setAsk_subject(String ask_subject) {
		this.ask_subject = ask_subject;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}


	
}
