package hils.Mypage1.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class EmailVO {

	private String subject;
    private String content;
    private String date;
    private String receiver;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	@Override
	public String toString() {
		return "EmailVO [subject=" + subject + ", content=" + content + ", date=" + date + ", receiver=" + receiver
				+ "]";
	}
    
    
}
