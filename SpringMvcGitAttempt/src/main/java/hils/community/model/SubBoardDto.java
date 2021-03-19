	package hils.community.model;

import java.sql.Date;

public class SubBoardDto {
	private int c_number;
	private int b_number;
	private Date c_reg_date;
	private String user_id;
	private String c_content;
	private int c_recocount;
	
	public int getC_recocount() {
		return c_recocount;
	}
	public void setC_recocount(int c_recocount) {
		this.c_recocount = c_recocount;
	}
	public int getC_number() {
		return c_number;
	}
	public void setC_number(int c_number) {
		this.c_number = c_number;
	}
	
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	public Date getC_reg_date() {
		return c_reg_date;
	}
	public void setC_reg_date(Date c_reg_date) {
		this.c_reg_date = c_reg_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	
	
}
