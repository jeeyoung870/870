package hils.manageCustomerService1.model;

import java.util.Date;

public class AnnouncementDto {
	private int annou_writing_num;
	private String subject;
	private String content;
	private Date annou_reg_date;
	private String user_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getAnnou_writing_num() {
		return annou_writing_num;
	}
	public void setAnnou_writing_num(int annou_writing_num) {
		this.annou_writing_num = annou_writing_num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAnnou_reg_date() {
		return annou_reg_date;
	}
	public void setAnnou_reg_date(Date annou_reg_date) {
		this.annou_reg_date = annou_reg_date;
	}
	
}
