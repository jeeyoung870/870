package hils.timeLine1.model;

public class CaloryOnedayScheduleDto {
	private String food_schedule_key;
	private String food_identifier;
	private int food_calory;
	private int food_amount;
	private int food_goal;
	
	public int getFood_goal() {
		return food_goal;
	}
	public void setFood_goal(int food_goal) {
		this.food_goal = food_goal;
	}
	public String getFood_schedule_key() {
		return food_schedule_key;
	}
	public void setFood_schedule_key(String food_schedule_key) {
		this.food_schedule_key = food_schedule_key;
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
	
}
