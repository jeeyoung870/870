package hils.Mypage1.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import lombok.Setter;

@Controller
public class SetProfileController implements ApplicationContextAware{

	private WebApplicationContext context = null;
	
	@Autowired
	SetProfileService setp;
	
	public void setContext(WebApplicationContext context) {
		this.context = context;
	}
	public void setSetp(SetProfileService setp) {
		this.setp = setp;
	}
	
	
	//경로에서 파일명만 구하는 메소드
	public String getFileName(String path) {
		int index = path.lastIndexOf("\\");
		String fName = path.substring(index + 1);
		return fName;
	}
	//마이페이지로 이동
		@RequestMapping("mypage")
		public ModelAndView toMypage(HttpServletRequest request) {
			//사용자 id 구하기
			HttpSession session = request.getSession();
			String user_id = (String)session.getAttribute("Email");
			//로그인 안했을경우
			if(user_id == null) {
				ModelAndView mav1 = new ModelAndView("loginform"); 
				return mav1;
			}else {		//로그인했을경우
				//프로필 정보 꺼내오기
				ProfileDto profileInfo = setp.profileInfo(user_id);
				//프사경로가 없다면, 기본이미지 파일명 전달,
				if (profileInfo.getProfile_img() == null) {
					profileInfo.setProfile_img("defaultimg.png");
				}else {	//경로 있다면 해당 파일명 전달
					String imgName = getFileName(profileInfo.getProfile_img());
					profileInfo.setProfile_img(imgName);
				}
				//운동힐린더 정보 꺼내오기
				Date hilDate = setp.latestdate(user_id);
				ProfileDto finder = new ProfileDto();
				finder.setUser_id(user_id);
				finder.setWorkout_reg_date(hilDate);
				ProfileDto hilDto = setp.workoutInfo1(finder); //아이디, 운동키, 날짜, 인증샷 정보
				List<ProfileDto> hilDto2 = setp.workoutInfo2(hilDto); //운동이름, 운동칼로리 list
				//System.out.println(hilDto2.get(0).getWorkout_name()); 
				
				String imgName2 = getFileName(hilDto.getWorkout_certi_path());
				hilDto.setWorkout_certi_path(imgName2);
				
				//운동키와 같은 키의 식단힐린더 정보 꺼내오기
				List<ProfileDto> hilDto3 = setp.dietInfo(hilDto.getWorkout_key());
				
				//mav에 정보를 add하여 mypage로 전송
				ModelAndView mav = new ModelAndView("mypage"); 
				mav.addObject("mpInfo", profileInfo);  //프로필정보
				mav.addObject("woInfo1", hilDto);  //아이디, 운동키, 날짜, 인증샷
				mav.addObject("woInfo2", hilDto2);  //운동이름, 운동칼로리 list
				mav.addObject("dInfo", hilDto3);  //식품명, 몇인분, 칼로리, 목표칼로리
				return mav;
			}
		}
		
	//프로필변경페이지로 이동
		@RequestMapping("profilechange")
		public ModelAndView toProfilechange(String user_id) {
			ProfileDto profileInfo = setp.profileInfo(user_id);
			//프사경로가 없다면, 기본이미지 파일명 전달,
			if (profileInfo.getProfile_img() == null) {
				profileInfo.setProfile_img("defaultimg.png");
			}else {	//경로 있다면 해당 파일명 전달
				String imgName = getFileName(profileInfo.getProfile_img());
				System.out.println(imgName);
				profileInfo.setProfile_img(imgName);
			}
			return new ModelAndView("profilechange", "pInfo", profileInfo);
		}
		
	//프사 삭제
	@RequestMapping("delpImg")
	public ModelAndView delpImg(String user_id) {
		int success = setp.delpimg(user_id);
		if(success == 0) {
			System.out.println("delete fail");
		}else {
			System.out.println("delete success");
		}
		return toProfilechange(user_id);
	}
		
	//프사변경페이지로 이동
	@RequestMapping("pimgchange")
	public ModelAndView toPimgchange(String user_id) {
		
		return new ModelAndView("pimgchange", "user_id", user_id);
	}
	
	//크롭한 이미지(file) ajax로 전송받기
	@PostMapping(value="saveIamge", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String saveIamge(								
			@RequestParam(value="croppedImage", required=true) MultipartFile[] file, String user_id) {
		System.out.println("file size : " + file[0].getSize() +" "+file[0].getOriginalFilename());
		printInfo(user_id, file[0]);
		String msg = "프로필 사진이 변경되었습니다.";
		Gson json = new Gson(); 
		return json.toJson(msg);
	}
	
	//id + 변경시각을 파일명으로 지어 지정정경로에 업로드
	private String upload(MultipartFile profileImg, String user_id) { 
		String ext = "png";		//img를 png확장자로 지정
		//파일명 지어주기
		String fileName = user_id + System.currentTimeMillis() + "." + ext;
		//업로드 경로 (이클립스 워크스페이스로 지정된 경로의 .metadata 폴더 안 경로)
		String dir = context.getServletContext().getRealPath("/resources/images/profilepic/"); 
		System.out.println("dir : " + dir);
		File f = new File(dir + fileName); 
		
		try {
			//File(파일경로명)이 저장된 f(파일)을 해당경로에 저장하기.
			profileImg.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return f.getPath();
	}
	
	//upload()하고 파일정보 출력한 후, 기존 프사파일 지우고 db에 파일저장경로 저장
	private void printInfo(String user_id, MultipartFile profileImg) {
			String path = upload(profileImg, user_id);
			//기존의 프사경로 가져오기
			String oldimgPath = setp.findProfileImg(user_id);
			//기존프사가 없다면,
			if(oldimgPath == null) {
				setp.addImgFile(user_id, path);
			}else {
				//기존프사파일 지우기
				File deleteFile = new File(oldimgPath);
				deleteFile.delete(); 
				//새 프사경로 db에 등록하기
				setp.addImgFile(user_id, path);
			}
		}
	
	@PostMapping(value="savePInfo", produces = "text/plain;charset=UTF-8")
	public String savePInfo(ProfileDto pdto) {
		int success = setp.changePInfo(pdto);
		System.out.println(success);
		if(success == 0) {
			System.out.println("insert fail");
		}else {
			System.out.println("insert success");
		}
		return "redirect:mypage";
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.context = (WebApplicationContext)applicationContext;
	}
	
}
