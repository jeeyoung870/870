package hils.timeLine1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hils.timeLine1.model.CaloryOnedayScheduleDto;
import hils.timeLine1.model.CalorySchedulerDto;
import hils.timeLine1.model.HilslinderDto;
import hils.timeLine1.model.WorkoutCalendarOnedayDto;
import hils.timeLine1.model.WorkoutCategoryDto;
import hils.timeLine1.model.WorkoutDataDto;

@Service
public class HilslinderService {

	@Autowired
	private HilslinderDao hilslinderDao;

	public void setHilslinderDao(HilslinderDao hilslinderDao) {
		this.hilslinderDao = hilslinderDao;
	}
//	public List<WorkoutDataDto> searchWorkoutService(String searchKeyword){
//		return hilslinderDao.searchWorkout(searchKeyword);
//	}
	public List<WorkoutCategoryDto> getWorkoutCategoryService(){
		return hilslinderDao.getWorkoutCategory();
	}
	public List<WorkoutDataDto> selectWorkoutService(String category1){
		return hilslinderDao.selectWorkout(category1);
	}
	public void insertHilslinderService(HilslinderDto hilslinderDto) {
		hilslinderDao.insertHilslinder(hilslinderDto);
	}
	public void insertWorkoutCalendarOnedayService(WorkoutCalendarOnedayDto workoutCalendarOnedayDto) {
		hilslinderDao.insertWorkoutCalendarOneday(workoutCalendarOnedayDto);
	}
	////////////////////////////food schedule 나중에 나눠야 함 //////////////////////////////
	public void insertCaloryScheduler(CalorySchedulerDto calorySchedulerDto) {
		hilslinderDao.insertCaloryScheduler(calorySchedulerDto);
	}
	public void insertScheduleSingle(CaloryOnedayScheduleDto caloryOnedaySchedulDto) {
		hilslinderDao.insertCalorySingleSchedule(caloryOnedaySchedulDto);
	}
	
}
