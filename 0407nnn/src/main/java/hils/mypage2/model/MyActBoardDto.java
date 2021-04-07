package hils.mypage2.model;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import hils.mypage2.controller.MyActivityController;

public class MyActBoardDto {
	
	@Autowired
	MyActivityController myActivityController;
	
	private int b_number;
	private String b_subject;
	private Date b_reg_date;
	private String user_id;
	private String b_content;
	private String b_category;
	private int b_readcount;
	private int b_recommendcount;
	
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	public String getB_subject() {
		/*return myActivityController.getShortString(b_subject, len);*/
		return b_subject;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}
	public Date getB_reg_date() {
		return b_reg_date;
	}
	public void setB_reg_date(Date b_reg_date) {
		this.b_reg_date = b_reg_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_category() {
		return b_category;
	}
	public void setB_category(String b_category) {
		this.b_category = b_category;
	}
	public int getB_readcount() {
		return b_readcount;
	}
	public void setB_readcount(int b_readcount) {
		this.b_readcount = b_readcount;
	}
	public int getB_recommendcount() {
		return b_recommendcount;
	}
	public void setB_recommendcount(int b_recommendcount) {
		this.b_recommendcount = b_recommendcount;
	}
	
}
