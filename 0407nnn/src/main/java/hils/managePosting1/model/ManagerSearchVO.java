package hils.managePosting1.model;

import java.util.Date;

public class ManagerSearchVO {
	private String b_category;
//	private String prepro_start_date;
//	private String prepro_end_date;
	private String search_option;
	private String user_id;
	private String b_subject;
	
	private String start_date;
	private String end_date;
	private String search_keyword;

	
	public String getB_subject() {
		return b_subject;
	}
	
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

//	public String getPrepro_start_date() {
//		return prepro_start_date;
//	}
//
//	public void setPrepro_start_date(String prepro_start_date) {
//		this.prepro_start_date = prepro_start_date;
//	}
//
//	public String getPrepro_end_date() {
//		return prepro_end_date;
//	}
//
//	public void setPrepro_end_date(String prepro_end_date) {
//		this.prepro_end_date = prepro_end_date;
//	}

	public String getB_category() {
		return b_category;
	}

	public void setB_category(String b_category) {
		this.b_category = b_category;
	}

	

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getSearch_option() {
		return search_option;
	}

	public void setSearch_option(String search_option) {
		this.search_option = search_option;
	}

	public String getSearch_keyword() {
		return search_keyword;
	}

	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}
	
	
}
