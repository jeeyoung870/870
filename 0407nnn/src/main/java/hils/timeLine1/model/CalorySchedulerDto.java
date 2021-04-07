package hils.timeLine1.model;

import java.util.Date;

public class CalorySchedulerDto {
	private String user_id;
	private String food_schedule_key;
	private Date schedule_date;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFood_schedule_key() {
		return food_schedule_key;
	}
	public void setFood_schedule_key(String food_schedule_key) {
		this.food_schedule_key = food_schedule_key;
	}
	public Date getSchedule_date() {
		return schedule_date;
	}
	public void setSchedule_date(Date schedule_date) {
		this.schedule_date = schedule_date;
	}	
	
	
}
