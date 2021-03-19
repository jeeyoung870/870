package hils.customerService.model;

import java.util.Date;

public class ReplyDto {
	private int rep_num;
	private int ask_num;
	private String rep_title;
	private String rep_content;
	private Date rep_date;
	public int getRep_num() {
		return rep_num;
	}
	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}
	public int getAsk_num() {
		return ask_num;
	}
	public void setAsk_num(int ask_num) {
		this.ask_num = ask_num;
	}
	public String getRep_title() {
		return rep_title;
	}
	public void setRep_title(String rep_title) {
		this.rep_title = rep_title;
	}
	public String getRep_content() {
		return rep_content;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	public Date getRep_date() {
		return rep_date;
	}
	public void setRep_date(Date rep_date) {
		this.rep_date = rep_date;
	}
	
}
