package hils.timeLine1.model;

import java.util.Date;

public class HilsCalendarDto {
	private String user_id;
	private String workout_key;
	private String food_schedule_key;
	private Date workout_reg_date;
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
	public String getFood_schedule_key() {
		return food_schedule_key;
	}
	public void setFood_schedule_key(String food_schedule_key) {
		this.food_schedule_key = food_schedule_key;
	}
	public Date getWorkout_reg_date() {
		return workout_reg_date;
	}
	public void setWorkout_reg_date(Date workout_reg_date) {
		this.workout_reg_date = workout_reg_date;
	}
	
}
