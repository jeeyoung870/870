package hils.managemainpage.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hils.managemainpage.service.FileService;

@Controller
public class MainPageManagementController implements ApplicationContextAware{

	/*
	 * modifyMainImage : 메인 이미지 변경 메소드
	 * modifyBannerImage : 배너 이미지 변경 메소드
	 * */
	private WebApplicationContext context = null;
	
	@Autowired
	FileService service;
	
	@RequestMapping("modifymainimage")
	public String form() {
		return "manageMainPage2";
	}
	
	@RequestMapping(value = "modifymainimage1", method = RequestMethod.POST)
	public String modifyMainImage(MultipartHttpServletRequest request) {
		
		MultipartFile main1 = request.getFile("main1"); // 파일 타입 파라미터
		MultipartFile main2 = request.getFile("main2"); // 파일 타입 파라미터
		MultipartFile main3 = request.getFile("main3"); // 파일 타입 파라미터
		MultipartFile banner = request.getFile("banner"); // 파일 타입 파라미터
		printInfo(main1,0); //  report.getOriginalFilename()
		printInfo(main2,1);
		printInfo(main3,2);
		printInfo(banner,3);
		
		return "manageMainPage2";
	}
	
	private void printInfo(MultipartFile report, int no) {
		System.out.println("업로드 한 파일: " + report.getOriginalFilename());
		System.out.println("no: " + no);
		String path = upload(report,no);
		System.out.println("path : " + path);
		
		//service.addFile(report.getOriginalFilename(), path); 
	}
	
	private String upload(MultipartFile report, int no) {
		//String dir ="C:\\git_home\\SpringMvcGitAttempt\\src\\main\\webapp\\resources\\images\\"; 						
		// 업로드 할 경로 /를 적어야 폴더 안에 파일이 들어감.
		//String origName = report.getOriginalFilename();
		//int index = origName.lastIndexOf("."); // .확장자
		//String ext = origName.substring(index+1); // 확장자
		//Random r = new Random();
		
		String fileName= "main"+no+".jpg";
		String dir = context.getServletContext().getRealPath("/resources/images/"+fileName);  
		
		File f = new File(dir);
		try {
			report.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "/resources/images/"+fileName;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
	
}
