package hils.timeLine1.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import hils.timeLine1.model.CaloryOnedayScheduleDto;
import hils.timeLine1.model.CalorySchedulerDto;
import hils.timeLine1.model.HilsCalendarDto;
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
	@RequestMapping("goHilslinderCalChange")
	public ModelAndView goHilslinderCalChange(HttpServletRequest request, String year, String month) {
		HttpSession session = request.getSession();
		
		
		String user_id = (String)session.getAttribute("Email");
		
		String zeroDay = "01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date input_date = null;
		try {
			if(Integer.parseInt(month) < 10) {
				input_date = sdf.parse(year + "0" + month + zeroDay);
			}else {
				input_date = sdf.parse(year + month + zeroDay);
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
	
		List<HilsCalendarDto> hilsCalList = hilslinderService.getCalDataListService(user_id, input_date);
		System.out.println(hilsCalList);
		List<String> calDataList = new ArrayList<String>();
		Date tempDate = null;
		for(HilsCalendarDto dto : hilsCalList) {
			tempDate = dto.getWorkout_reg_date();
			calDataList.add(sdf.format(tempDate));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("timeLine1/hilslinderCalendar");
		mav.addObject("month", month);
		mav.addObject("year", year);
		mav.addObject("calDataList", calDataList);
		
		return mav;
	}
	@RequestMapping("goHilslinderCal")
	public ModelAndView goHilslinderCal(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		
		String user_id = (String)session.getAttribute("Email");
		Date input_date = new Date();
		ModelAndView mav = new ModelAndView();
		List<HilsCalendarDto> hilsCalList = hilslinderService.getCalDataListService(user_id, input_date);
		List<String> calDataList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date tempDate = null;
		for(HilsCalendarDto dto : hilsCalList) {
			tempDate = dto.getWorkout_reg_date();
			calDataList.add(sdf.format(tempDate));
		}
		mav.setViewName("timeLine1/hilslinderCalendar");
		mav.addObject("calDataList", calDataList);
		return mav;
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
	@Transactional
	public String submitHilslinder(HttpServletRequest request,@RequestParam String workout_one_day, 
			MultipartFile imageFile, @DateTimeFormat(pattern="yyyy-MM-dd") Date date, String foodSchedule,
			int food_goal) {
		
		
		
		/////////////////////// date processed ///////////////////////
		
		String currentTimeIdentifier = makeDateToIdentifierToken(date);
		
		////////////////////// file handler //////////////////////////
		
		String originalFileName = imageFile.getOriginalFilename();
		String url = applicationContext.getServletContext().getRealPath("");
		url += "/tempRepository";
		File file = new File(url);
		file.mkdirs();
		url += originalFileName;
		file =  new File(url);
		try {
			imageFile.transferTo(file); // Destination file [C:\ProjectMergedRepository\main\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMvcGitAttempt] already exists and could not be deleted
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HilslinderDto hilslinderDto = new HilslinderDto();
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email");
		hilslinderDto.setUser_id(user_id);
		hilslinderDto.setWeight(70);
		hilslinderDto.setWorkout_certi_path(url);
		//"@"를 포함하고 잇는지 체크해야 한다	
		String workoutKey = user_id.split("@")[0] + currentTimeIdentifier; ///// 조정 필요 du is user_id initial
		hilslinderDto.setWorkout_key(workoutKey);
		hilslinderDto.setWorkout_reg_date(date);
		hilslinderService.insertHilslinderService(hilslinderDto);
		
		///////////////////////////////////////food schedule//////////////////////
		uploadFoodSchedule(request, foodSchedule, date, food_goal);
		
		////////////////////////////////////////////////////////////
	
		WorkoutCalendarOnedayDto workoutCalendarOnedayDto = new WorkoutCalendarOnedayDto();
		String[] workoutList = workout_one_day.split(",");
		for(String elem : workoutList) {
			workoutCalendarOnedayDto.setWorkout_key(workoutKey);
			workoutCalendarOnedayDto.setWorkout_name(elem.split(":")[0]);
			workoutCalendarOnedayDto.setWorkout_hours(elem.split(":")[1]);
			hilslinderService.insertWorkoutCalendarOnedayService(workoutCalendarOnedayDto);
		}
		return "redirect:goHilslinderCal";
	}
	
	@Transactional
	public void uploadFoodSchedule(HttpServletRequest request, String foodSchedule,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date, int food_goal) {
		
		CalorySchedulerDto calorySchedulerDto = new CalorySchedulerDto();
		CaloryOnedayScheduleDto caloryOnedayScheduleDto = new CaloryOnedayScheduleDto();
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email");
		calorySchedulerDto.setUser_id(user_id);
		//calorySchedulerDto.setFood_schedule_key();
		String dateToken = makeDateToIdentifierToken(date);
		String identifier = user_id + dateToken; // du는 user_id 이니셜입니다.
		calorySchedulerDto.setFood_schedule_key(identifier);
		calorySchedulerDto.setSchedule_date(date);
		hilslinderService.insertCaloryScheduler(calorySchedulerDto);
		
		caloryOnedayScheduleDto.setFood_schedule_key(identifier);
		String[] commaProcessedSchedule = foodSchedule.split(",");
		for(String elem : commaProcessedSchedule) {
			String[] finalSplitedSchedule = elem.split(":");
			caloryOnedayScheduleDto.setFood_goal(food_goal);
			caloryOnedayScheduleDto.setFood_amount(Integer.parseInt(finalSplitedSchedule[2]));
			caloryOnedayScheduleDto.setFood_calory(Integer.parseInt(finalSplitedSchedule[1]));
			caloryOnedayScheduleDto.setFood_identifier(finalSplitedSchedule[0]);
			
			hilslinderService.insertScheduleSingle(caloryOnedayScheduleDto);
		}
		
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = (WebApplicationContext)applicationContext;
	}
	
	public String makeDateToIdentifierToken(Date date) {
		Date currentDate = date;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String currentTimeIdentifier = simpleDateFormat.format(currentDate);
		return currentTimeIdentifier;
	}
	@RequestMapping(value = "goToHilsWithDate")
	public ModelAndView goToHilsWithDate(@RequestParam("date")String dateString) {
		Date date = new Date();
		String processedString = (Integer.parseInt(dateString) + 1) + "";
		
		try {
			date =  new SimpleDateFormat("yyyyMMdd").parse(processedString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("timeLine1/hilslinderMain");
		mav.addObject("date", date);
		
		return mav;
	}
}
