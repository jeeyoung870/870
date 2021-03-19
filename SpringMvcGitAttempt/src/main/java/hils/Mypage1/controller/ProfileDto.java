package hils.Mypage1.controller;

import lombok.Getter;
import lombok.Setter;

/*@Getter
@Setter*/
public class ProfileDto {

	private String user_id;
	private String user_email;
	private String user_phone;
	private String password;
	private char enabled;
	
	private int weight;
	private int height;
	private String introduce;
	private char is_hellinder_open;
	private char is_withboard;
	private String location;
	private String profile_img;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getEnabled() {
		return enabled;
	}
	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public char getIs_hellinder_open() {
		return is_hellinder_open;
	}
	public void setIs_hellinder_open(char is_hellinder_open) {
		this.is_hellinder_open = is_hellinder_open;
	}
	public char getIs_withboard() {
		return is_withboard;
	}
	public void setIs_withboard(char is_withboard) {
		this.is_withboard = is_withboard;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	
	
	
}
