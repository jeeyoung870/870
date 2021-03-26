package hils.timeLine1.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hils.timeLine1.model.CaloryOnedayScheduleDto;
import hils.timeLine1.model.CalorySchedulerDto;
import hils.timeLine1.model.HilsCalendarDto;
import hils.timeLine1.model.HilslinderDto;
import hils.timeLine1.model.WorkoutCalendarOnedayDto;
import hils.timeLine1.model.WorkoutCategoryDto;
import hils.timeLine1.model.WorkoutDataDto;

@Component
public class HilslinderDao {
	
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
		
//	public List<WorkoutDataDto> searchWorkout(String searchKeyword){
//		return sqlSession.selectList("hilslinder.searchWorkout", searchKeyword);
//	}
	public List<WorkoutCategoryDto> getWorkoutCategory() {
		return sqlSession.selectList("hilslinder.getWorkoutCategory");
	}
	public List<WorkoutDataDto> selectWorkout(String category1){
		return sqlSession.selectList("hilslinder.selectCategory", category1);
	}
	public void insertHilslinder(HilslinderDto hilslinderDto) {
		sqlSession.insert("hilslinder.insertHilslinder", hilslinderDto);
	}
	public void insertWorkoutCalendarOneday(WorkoutCalendarOnedayDto workoutCalendarOnedayDto) {
		sqlSession.insert("hilslinder.insertWorkoutOneday", workoutCalendarOnedayDto);
	}
	///////////////////////////////foodScheduler////////////////////////////
	public void insertCaloryScheduler(CalorySchedulerDto calorySchedulerDto) {
		sqlSession.insert("hilslinder.insertCaloryScehdule", calorySchedulerDto);
	}
	public void insertCalorySingleSchedule(CaloryOnedayScheduleDto caloryOnedayScheduleDto) {
		sqlSession.insert("hilslinder.insertSingleCalorySchedule", caloryOnedayScheduleDto);
	}
	///////////////////////////////////////////////////////////////////////////
	public List<HilsCalendarDto> getCalDataList(Map<String, Object> paraMap){
		return sqlSession.selectList("hilslinder.selectCal", paraMap);
	}
	
}
