package hils.timeLine1.model;

import java.util.Date;

public class HilslinderDto {
	private String user_id;
	private String workout_key;
	private int weight;
	private Date workout_reg_date;
	private String workout_certi_path;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getWorkout_key() {
		return workout_key;
	}
	public void setWorkout_key(String workout_key) {
		this.workout_key = workout_key;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Date getWorkout_reg_date() {
		return workout_reg_date;
	}
	public void setWorkout_reg_date(Date workout_reg_date) {
		this.workout_reg_date = workout_reg_date;
	}
	public String getWorkout_certi_path() {
		return workout_certi_path;
	}
	public void setWorkout_certi_path(String workout_certi_path) {
		this.workout_certi_path = workout_certi_path;
	}
	
	
}
