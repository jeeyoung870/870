package download.upload;


import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import download.upload.FileService;

@Controller
public class ReportSubmissionController {
	
	@Autowired
	FileService service;


@RequestMapping("/report/submission.do")
public String form() {     
		return "report/submissionForm";
	}

//파일업로드는 무조건 Post방식으로 저장. MultipartFile type
@RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
public String submitReport1(String studentNumber, @RequestParam MultipartFile report) {
		printInfo(studentNumber, report);
		return "report/submissionComplete";
	}


//파일을 지정한 경로에 업로드(복붙)
private String upload(MultipartFile report) {
	//업로드 경로 
	String dir = "c://upload/";
	String origName = report.getOriginalFilename();
	int index = origName.lastIndexOf(".");
	//ext : .다음에 확장자명 구하기
	String ext = origName.substring(index + 1);
	
	Random r = new Random();
	String fileName = System.currentTimeMillis() + "_" + r.nextInt(50) + "." + ext;
	File f = new File(dir + fileName);
	
	try {
		//File(파일경로명)이 저장된 f(파일)을 해당경로에 저장하기.
		report.transferTo(f);
	} catch (IllegalStateException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return f.getPath();
}


//db에 파일정보 등록하기(복붙)
private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: "
				+ report.getOriginalFilename());	//파일 실제이름 출력
		String path = upload(report);
		System.out.println("업로드 된 경로 : " + path);
		
		service.addFile(report.getOriginalFilename(), path);
	}

//getFile메소드 : 파일타입의 객체 꺼내기
@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
public String submitReport2(MultipartHttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		return "report/submissionComplete";
	}

@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
public String submitReport3(ReportCommand reportCommand) {
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		return "report/submissionComplete";
	}
	
public void setService(FileService service) {
	this.service = service;
}

}

