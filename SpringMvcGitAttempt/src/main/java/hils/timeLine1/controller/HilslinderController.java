package hils.timeLine1.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import hils.timeLine1.model.CaloryOnedayScheduleDto;
import hils.timeLine1.model.CalorySchedulerDto;
import hils.timeLine1.model.HilslinderDto;
import hils.timeLine1.model.WorkoutCalendarOnedayDto;
import hils.timeLine1.model.WorkoutCategoryDto;
import hils.timeLine1.model.WorkoutDataDto;
import hils.timeLine1.service.HilslinderService;

@Controller
public class HilslinderController implements ApplicationContextAware{

	private WebApplicationContext applicationContext;
	
	@Autowired
	private HilslinderService hilslinderService;
	
	public void setHilslinderService(HilslinderService hilslinderService) {
		this.hilslinderService = hilslinderService;
	}
	@RequestMapping("/goHilslinderMain")
	public String goHilslinderMain() {
		return "timeLine1/hilslinderMain";
	}
	@RequestMapping("goHilslinderCal")
	public String goHilslinderCal() {
		return "timeLine1/hilslinderCalendar";
	}
//	@RequestMapping("/doWorkoutSearch")
//	@ResponseBody
//	public String doWorkoutSearch(String userInput, Model model) {
//		List<WorkoutDataDto> workoutList = hilslinderService.searchWorkoutService(userInput);
//		Gson json = new Gson();
//		model.addAttribute("workoutList", workoutList);
//		return json.toJson(model);
//	}
	
	@RequestMapping(value = "/getWorkoutCategory", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String getWorkoutCategory(Model model) {
		Gson json = new Gson();
		List<WorkoutCategoryDto> resultList = hilslinderService.getWorkoutCategoryService();
		model.addAttribute("categoryList", resultList);
		return json.toJson(model);
	}
	
	@RequestMapping(value = "/selectCategory1", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String selectCategory1(String category1, Model model) {
		Gson json = new Gson();
		model.addAttribute("workoutList", hilslinderService.selectWorkoutService(category1));
		return json.toJson(model);
	}
	
	@RequestMapping(value = "submitHilslinder")
	public String submitHilslinder(@RequestParam String workout_one_day, MultipartFile imageFile) {
		
		/////////////////////// date processed ///////////////////////
		
		String currentTimeIdentifier = makeDateToIdentifierToken();
		
		////////////////////// file handler //////////////////////////
		
		String originalFileName = imageFile.getOriginalFilename();
		String url = applicationContext.getServletContext().getRealPath("/tempRepository/" + originalFileName);
		File file = new File(url);
		try {
			imageFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HilslinderDto hilslinderDto = new HilslinderDto();
		hilslinderDto.setUser_id("dummy");
		hilslinderDto.setWeight(70);
		hilslinderDto.setWorkout_certi_path(url);
		
		String workoutKey = "du" + currentTimeIdentifier; ///// 조정 필요 du is user_id initial
		hilslinderDto.setWorkout_key(workoutKey);
		hilslinderService.insertHilslinderService(hilslinderDto);
		
		////////////////////////////////////////////////////////////
	
		WorkoutCalendarOnedayDto workoutCalendarOnedayDto = new WorkoutCalendarOnedayDto();
		String[] workoutList = workout_one_day.split(",");
		for(String elem : workoutList) {
			workoutCalendarOnedayDto.setWorkout_key(workoutKey);
			workoutCalendarOnedayDto.setWorkout_name(elem.split(":")[0]);
			workoutCalendarOnedayDto.setWorkout_hours(elem.split(":")[1]);
			hilslinderService.insertWorkoutCalendarOnedayService(workoutCalendarOnedayDto);
		}
		return "/main";
	}
	@RequestMapping(value = "uploadFoodSchedule", produces = "application/text;charset=utf-8")
	public String uploadFoodSchedule(String foodSchedule) {
		
		CalorySchedulerDto calorySchedulerDto = new CalorySchedulerDto();
		CaloryOnedayScheduleDto caloryOnedayScheduleDto = new CaloryOnedayScheduleDto();
		
		calorySchedulerDto.setUser_id("dummy");
		//calorySchedulerDto.setFood_schedule_key();
		String dateToken = makeDateToIdentifierToken();
		String identifier = "du" + dateToken; // du는 user_id 이니셜입니다.
		calorySchedulerDto.setFood_schedule_key(identifier);
		hilslinderService.insertCaloryScheduler(calorySchedulerDto);
		
		caloryOnedayScheduleDto.setFood_schedule_key(identifier);
		String[] commaProcessedSchedule = foodSchedule.split(",");
		for(String elem : commaProcessedSchedule) {
			String[] finalSplitedSchedule = elem.split(":");
			caloryOnedayScheduleDto.setFood_amount(Integer.parseInt(finalSplitedSchedule[2]));
			caloryOnedayScheduleDto.setFood_calory(Integer.parseInt(finalSplitedSchedule[1]));
			caloryOnedayScheduleDto.setFood_identifier(finalSplitedSchedule[0]);
			
			hilslinderService.insertScheduleSingle(caloryOnedayScheduleDto);
		}
		
		return "./hilslinderMain";
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = (WebApplicationContext)applicationContext;
	}
	
	public String makeDateToIdentifierToken() {
		Date currentDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYMMddHHmmss");
		String currentTimeIdentifier = simpleDateFormat.format(currentDate);
		return currentTimeIdentifier;
	}
}
