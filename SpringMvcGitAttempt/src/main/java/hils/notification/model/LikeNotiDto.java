package hils.notification.model;

public class LikeNotiDto {
	private String thumbing_user;
	private String thumbed_user;
	private int b_number;
	private String b_subject;
	public String getThumbing_user() {
		return thumbing_user;
	}
	public void setThumbing_user(String thumbing_user) {
		this.thumbing_user = thumbing_user;
	}
	public String getThumbed_user() {
		return thumbed_user;
	}
	public void setThumbed_user(String thumbed_user) {
		this.thumbed_user = thumbed_user;
	}
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	public String getB_subject() {
		return b_subject;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}
	
}
