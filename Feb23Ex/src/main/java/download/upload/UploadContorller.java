package download.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;

@Controller
public class UploadContorller {
	
	@Autowired
	FileService service;
	
	@RequestMapping(value = { "/uploadPath.do" }, method = RequestMethod.GET)
	public String form() {
		return "uploadAjax/form";  
	}
	
	//mtfRequest: 파일 업로드 처리를 위한 인자
	@ResponseBody	//메소드가 리턴한 자바객체를 클라이언트에 바로 전달
	@RequestMapping(value = { "/uploadPath.do" }, method = RequestMethod.POST, produces = "json/plain;charset=UTF-8")
	public String uploadPath(MultipartHttpServletRequest mtfRequest, 
			final HttpServletRequest request, 
			final HttpServletResponse response) {
		int res = 0;
		System.out.println("제목 > " + request.getParameter("title"));
		System.out.println("내용 > " + request.getParameter("contents"));
		if(mtfRequest != null) {
			List<MultipartFile> fileList = mtfRequest.getFiles("fileList");
			for(int i=0; i<fileList.size(); i++) {
				MultipartFile multi = fileList.get(i);
				System.out.println(multi.isEmpty());
				if (multi.isEmpty()==true) {
					res =  0; //업로드실패
				}else {
					//업로드
					printInfo(multi);
					res=1;
				}
			}
		}
		Gson gson = new Gson();
		return gson.toJson(res);
	}
	
	
	
	//파일을 지정한 경로에 업로드
	private String upload(MultipartFile file) {
		//업로드 경로 
		String dir = "c://upload/";
		String origName = file.getOriginalFilename();
		int index = origName.lastIndexOf(".");
		//ext : .다음에 확장자명 구하기
		String ext = origName.substring(index + 1);
		
		Random r = new Random();
		String fileName = System.currentTimeMillis() + "_" + r.nextInt(50) + "." + ext;
		File f = new File(dir + fileName);
		
		try {
			//File(파일경로명)이 저장된 f(파일)을 해당경로에 저장하기.
			file.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return f.getPath();
	}

	//upload()로 파일업로드하고, db에 파일정보 등록하기
	private void printInfo(MultipartFile file) {
			System.out.println("파일명 : " + file.getOriginalFilename()	//파일 실제이름 출력
					+ "\n크기(byte) : " + file.getSize());	
			String path = upload(file);
			System.out.println("업로드 된 경로 : " + path);
			
			service.addFile(file.getOriginalFilename(), path);
		}
}
