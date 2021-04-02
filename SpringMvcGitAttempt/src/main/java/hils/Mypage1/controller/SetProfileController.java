package hils.Mypage1.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

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
@Setter
public class SetProfileController implements ApplicationContextAware{

	private WebApplicationContext context = null;
	
	@Autowired
	SetProfileService setp;
	
	//��ο��� ���ϸ� ���ϴ� �޼ҵ�
	public String getFileName(String path) {
		int index = path.lastIndexOf("\\");
		String fName = path.substring(index + 1);
		return fName;
	}
	//������������ �̵�
		@RequestMapping("mypage")
		public ModelAndView toMypage() {
			//������ ���� ��������
			ProfileDto profileInfo = setp.profileInfo("dummy1");
			//�����ΰ� ���ٸ�, �⺻�̹��� ���ϸ� ����,
			if (profileInfo.getProfile_img() == null) {
				profileInfo.setProfile_img("defaultimg.png");
			}else {	//��� �ִٸ� �ش� ���ϸ� ����
				String imgName = getFileName(profileInfo.getProfile_img());
				profileInfo.setProfile_img(imgName);
			}
			//������� ���� ��������
			Date hilDate = setp.latestdate("dummy1");
			ProfileDto finder = new ProfileDto();
			finder.setUser_id("dummy1");
			finder.setWorkout_reg_date(hilDate);
			ProfileDto hilDto = setp.workoutInfo1(finder); //���̵�, �Ű, ��¥, ������ ����
			List<ProfileDto> hilDto2 = setp.workoutInfo2(hilDto); //��̸�, �Į�θ� list
			//System.out.println(hilDto2.get(0).getWorkout_name()); 
			
			String imgName2 = getFileName(hilDto.getWorkout_certi_path());
			hilDto.setWorkout_certi_path(imgName2);
			
			//�Ű�� ���� Ű�� �Ĵ������� ���� ��������
			List<ProfileDto> hilDto3 = setp.dietInfo(hilDto.getWorkout_key());
			
			//mav�� ������ add�Ͽ� mypage�� ����
			ModelAndView mav = new ModelAndView("mypage"); 
			mav.addObject("mpInfo", profileInfo);  //����������
			mav.addObject("woInfo1", hilDto);  //���̵�, �Ű, ��¥, ������
			mav.addObject("woInfo2", hilDto2);  //��̸�, �Į�θ� list
			mav.addObject("dInfo", hilDto3);  //��ǰ��, ���κ�, Į�θ�, ��ǥĮ�θ�
			return mav;
		}
		
	//�����ʺ����������� �̵�
		@RequestMapping("profilechange")
		public ModelAndView toProfilechange(String user_id) {
			ProfileDto profileInfo = setp.profileInfo(user_id);
			//�����ΰ� ���ٸ�, �⺻�̹��� ���ϸ� ����,
			if (profileInfo.getProfile_img() == null) {
				profileInfo.setProfile_img("defaultimg.png");
			}else {	//��� �ִٸ� �ش� ���ϸ� ����
				String imgName = getFileName(profileInfo.getProfile_img());
				System.out.println(imgName);
				profileInfo.setProfile_img(imgName);
			}
			return new ModelAndView("profilechange", "pInfo", profileInfo);
		}
		
	//���� ����
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
		
	//���纯���������� �̵�
	@RequestMapping("pimgchange")
	public ModelAndView toPimgchange(String user_id) {
		
		return new ModelAndView("pimgchange", "user_id", user_id);
	}
	
	//ũ���� �̹���(file) ajax�� ���۹ޱ�
	@PostMapping(value="saveIamge", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String saveIamge(
			@RequestParam(value="croppedImage", required=true) MultipartFile[] file, String user_id) {
		//System.out.println("file size : " + file[0].getSize() +" "+file[0].getOriginalFilename());
		printInfo(user_id, file[0]);
		String msg = "������ ������ ����Ǿ����ϴ�.";
		Gson json = new Gson(); 
		return json.toJson(msg);
	}
	
	//id + ����ð��� ���ϸ����� ���� ��������ο� ���ε�
	private String upload(MultipartFile profileImg, String user_id) { 
		String ext = "png";		//img�� pngȮ���ڷ� ����
		//���ϸ� �����ֱ�
		String fileName = user_id + System.currentTimeMillis() + "." + ext;
		//���ε� ��� (��Ŭ���� ��ũ�����̽��� ������ ����� .metadata ���� �� ���)
		String dir = context.getServletContext().getRealPath("/resources/images/profilepic/"); 
		System.out.println("dir : " + dir);
		File f = new File(dir + fileName); 
		
		try {
			//File(���ϰ�θ�)�� ����� f(����)�� �ش��ο� �����ϱ�.
			profileImg.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return f.getPath();
	}
	
	//upload()�ϰ� �������� ����� ��, ���� �������� ����� db�� ���������� ����
	private void printInfo(String user_id, MultipartFile profileImg) {
			String path = upload(profileImg, user_id);
			//������ ������ ��������
			String oldimgPath = setp.findProfileImg(user_id);
			//�������簡 ���ٸ�,
			if(oldimgPath == null) {
				setp.addImgFile(user_id, path);
			}else {
				//������������ �����
				File deleteFile = new File(oldimgPath);
				deleteFile.delete(); 
				//�� ������ db�� ����ϱ�
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
