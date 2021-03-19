package hils.customerService.model;

import java.util.Date;

public class AskDto {
	private int ask_num;
	private String user_id;
	private String ask_title;
	private String ask_content;
	private Date ask_date;
	private String is_replied;
	public AskDto() {};
	
//	public AskDto(int ask_num, String user_id, String ask_title, String ask_content, Date ask_date, String is_replied) {
//		this.ask_num = ask_num;
//		this.user_id = user_id;
//		this
//	}
	
	public int getAsk_num() {
		return ask_num;
	}
	public void setAsk_num(int ask_num) {
		this.ask_num = ask_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAsk_title() {
		return ask_title;
	}
	public void setAsk_title(String ask_title) {
		this.ask_title = ask_title;
	}
	public String getAsk_content() {
		return ask_content;
	}
	public void setAsk_content(String ask_content) {
		this.ask_content = ask_content;
	}
	public Date getAsk_date() {
		return ask_date;
	}
	public void setAsk_date(Date ask_date) {
		this.ask_date = ask_date;
	}
	public String getIs_replied() {
		return is_replied;
	}
	public void setIs_replied(String is_replied) {
		this.is_replied = is_replied;
	}	
	
}
