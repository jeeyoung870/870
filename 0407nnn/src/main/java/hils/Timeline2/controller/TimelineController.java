package hils.Timeline2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import hils.Mypage1.controller.ProfileDto;
import hils.Mypage1.controller.SetProfileService;

@Controller
public class TimelineController {
	
	@Autowired
	SetProfileService setp;
	
	public void setSetp(SetProfileService setp) {
		this.setp = setp;
	}
	
	//경로에서 파일명만 구하는 메소드
	public String getFileName(String path) {
		int index = path.lastIndexOf("\\");
		String fName = path.substring(index + 1);
		return fName;
	}
		
	//타임라인으로 이동
	@GetMapping("timeline")
	public ModelAndView toTimeline(HttpServletRequest request) {
		//사용자 id 구하기
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("Email");
		
		//로그인 안했을경우
		if(user_id == null) {
			ModelAndView mav1 = new ModelAndView("loginform"); 
			return mav1;
		}else {		//로그인했을경우
			List<Object> hilinfo = new ArrayList<>();
			//가장 최근 6개 WORKOUT_KEY 찾기
			int last = 6;
			List<String> keylist = setp.early6key(last);
			
			for(int i=0; i < keylist.size(); i++) {
				ProfileDto hilDto = setp.workoutInfo1_2(keylist.get(i)); //아이디, 운동키, 날짜, 인증샷 정보
				//프로필 정보 꺼내오기
				ProfileDto profileInfo = setp.profileInfo(hilDto.getUser_id());
				//프사경로가 없다면, 기본이미지 파일명 저장,
				if (profileInfo.getProfile_img() == null) {
					hilDto.setProfile_img("defaultimg.png");
				}else {	//경로 있다면 해당 파일명 저장
					String imgName = getFileName(profileInfo.getProfile_img());
					hilDto.setProfile_img(imgName);
				}
				String imgName2 = getFileName(hilDto.getWorkout_certi_path());
				hilDto.setWorkout_certi_path(imgName2);
				
				List<ProfileDto> hilDto2 = setp.workoutInfo2(hilDto); //운동이름, 운동칼로리 list
				//System.out.println(hilDto2.get(0).getWorkout_name()); 
				
				//운동키와 같은 키의 식단힐린더 정보 꺼내오기
				List<ProfileDto> hilDto3 = setp.dietInfo(hilDto.getWorkout_key());
				
				List<Object> hhh = new ArrayList<>(); 
				hhh.add(hilDto);	//아이디, 프사, 운동키, 날짜, 인증샷
				hhh.add(hilDto2);	 //운동이름, 운동칼로리 list
				hhh.add(hilDto3);	//식품명, 몇인분, 칼로리, 목표칼로리 list
				
				hilinfo.add(hhh);
			}
			//mav에 모든 정보를 add
			return new ModelAndView("timeline", "hilinfo", hilinfo);
		}
	}
	
	//ajax로 더보기 6개데이터 전달
	@RequestMapping(value="timeline", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String more6hils(int last) {
		List<Object> hilinfo = new ArrayList<>();
		System.out.println(last);
		List<String> keylist = setp.early6key(last);
		
		for(int i=0; i < keylist.size(); i++) {
			ProfileDto hilDto = setp.workoutInfo1_2(keylist.get(i)); //아이디, 운동키, 날짜, 인증샷 정보
			//프로필 정보 꺼내오기
			ProfileDto profileInfo = setp.profileInfo(hilDto.getUser_id());
			//프사경로가 없다면, 기본이미지 파일명 저장,
			if (profileInfo.getProfile_img() == null) {
				hilDto.setProfile_img("defaultimg.png");
			}else {	//경로 있다면 해당 파일명 저장
				String imgName = getFileName(profileInfo.getProfile_img());
				hilDto.setProfile_img(imgName);
			}
			String imgName2 = getFileName(hilDto.getWorkout_certi_path());
			hilDto.setWorkout_certi_path(imgName2);
			
			List<ProfileDto> hilDto2 = setp.workoutInfo2(hilDto); //운동이름, 운동칼로리 list
			//System.out.println(hilDto2.get(0).getWorkout_name()); 
			
			//운동키와 같은 키의 식단힐린더 정보 꺼내오기
			List<ProfileDto> hilDto3 = setp.dietInfo(hilDto.getWorkout_key());
			
			List<Object> hhh = new ArrayList<>(); 
			hhh.add(hilDto);	//아이디, 프사, 운동키, 날짜, 인증샷
			hhh.add(hilDto2);	 //운동이름, 운동칼로리 list
			hhh.add(hilDto3);	//식품명, 몇인분, 칼로리, 목표칼로리 list
			hilinfo.add(hhh);
		}
		Gson json = new Gson(); 
		System.out.println(json.toJson(hilinfo));
		return json.toJson(hilinfo);
	}
	
	
}
