package hils.mypage2.model;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ProfileDto {
	//users_register
	private String user_id;
	private String user_email;
	private String user_phone;
	private String password;
	private char enabled;
	
	//users_profile
	private int weight;
	private int height;
	private String introduce;
	private char is_hellinder_open;
	private char is_withboard;
	private String location;
	private String profile_img;
	
	//힐린더
	//1. 운동힐린더
	//hellinder 테이블
	private Date workout_reg_date;
	private String workout_key;
	private String workout_certi_path;
	//workout_calendar_oneday 테이블
	private String workout_name;
	private int workout_hours;
	
	//2. 식단힐린더
	//calory_oneday_schedule 테이블
	private String food_identifier;
	private int food_calory;
	private int food_amount;
	private int food_goal;
	
	
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
	public Date getWorkout_reg_date() {
		return workout_reg_date;
	}
	public void setWorkout_reg_date(Date workout_reg_date) {
		this.workout_reg_date = workout_reg_date;
	}
	public String getWorkout_key() {
		return workout_key;
	}
	public void setWorkout_key(String workout_key) {
		this.workout_key = workout_key;
	}
	public String getWorkout_certi_path() {
		return workout_certi_path;
	}
	public void setWorkout_certi_path(String workout_certi_path) {
		this.workout_certi_path = workout_certi_path;
	}
	public String getWorkout_name() {
		return workout_name;
	}
	public void setWorkout_name(String workout_name) {
		this.workout_name = workout_name;
	}
	public int getWorkout_hours() {
		return workout_hours;
	}
	public void setWorkout_hours(int workout_hours) {
		this.workout_hours = workout_hours;
	}
	public String getFood_identifier() {
		return food_identifier;
	}
	public void setFood_identifier(String food_identifier) {
		this.food_identifier = food_identifier;
	}
	public int getFood_calory() {
		return food_calory;
	}
	public void setFood_calory(int food_calory) {
		this.food_calory = food_calory;
	}
	public int getFood_amount() {
		return food_amount;
	}
	public void setFood_amount(int food_amount) {
		this.food_amount = food_amount;
	}
	public int getFood_goal() {
		return food_goal;
	}
	public void setFood_goal(int food_goal) {
		this.food_goal = food_goal;
	}
	
	
}
