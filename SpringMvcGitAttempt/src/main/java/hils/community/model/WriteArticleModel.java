package hils.community.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;


public class WriteArticleModel {
	private String category;
	@NotEmpty
	private String b_subject;
	@NotEmpty
	private String b_content;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getB_subject() {
		return b_subject;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	
}
