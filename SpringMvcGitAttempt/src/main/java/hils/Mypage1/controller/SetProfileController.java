package hils.Mypage1.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.Setter;

@Controller
@Setter
public class SetProfileController {

	@Autowired
	SetProfileService setp;
	
	
	@PostMapping("saveIamge")
	public String saveIamge(@RequestParam(value="croppedImage", required=true) MultipartFile[] file) {
		//System.out.println("file size : " + file[0].getSize() +" "+file[0].getOriginalFilename());
		printInfo("jyjy", file[0]);
		return "mypage";
	}

	
	
	//랜덤파일명으로 지정경로에 업로드
	private String upload(MultipartFile profileImg) {
		//업로드 경로 
		String dir = "c://upload/";
		String origName = profileImg.getOriginalFilename();
		System.out.println(origName);
		//ext : .다음에 확장자명 구하기
		//int index = origName.lastIndexOf(".");
		//String ext = origName.substring(index + 1);
		String ext = "png";		//img를 png확장자로 지정
		//랜덤 파일명 지어주기
		Random r = new Random();
		String fileName = System.currentTimeMillis() + "_" + r.nextInt(50) + "." + ext;
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
			String path = upload(profileImg);
			System.out.println("id+경로+원래파일명 : "+user_id+" "+ path+ " "+profileImg.getOriginalFilename());
			//기존의 프사경로 가져오기
			String oldimgPath = setp.findProfileImg(user_id);
			//기존프사파일 지우기
			File deleteFile = new File(oldimgPath);
			deleteFile.delete(); 
			//새 프사경로 db에 등록하기
			setp.addImgFile(user_id, path);
		}
	
}
