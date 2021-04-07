package files.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;

import board.model.BoardDto;
import board.model.BoardListModel;
import board.service.BoardService;
import board.service.PasswordCheckException;
import files.model.FBoardDto;
import files.model.FileDto;
import files.service.FBoardService;

@Controller
public class FileBController {
	
	@Autowired
	FBoardService service;
	 
	@GetMapping("/flist")
	public String list(@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "per", defaultValue = "4") int per, Model m) {
		
		BoardListModel list = service.list(pageNum, per);
		list.setPer(per);
		m.addAttribute("list", list);
		m.addAttribute("per", per);
		int number = list.getCount() - (pageNum - 1) * per;
		m.addAttribute("number", number);
		return "file/FList";
	}
	
	@ResponseBody
	//@PostMapping("/flist")
	@RequestMapping(value = { "/flist" }, method = RequestMethod.POST, produces = "json/plain;charset=UTF-8")
	public String write(BoardDto dto, HttpServletRequest request,
			MultipartHttpServletRequest mtfRequest) {
		int res = 0;
		System.out.println("제목 : " + dto.getSubject());
		System.out.println("설명 : " + dto.getContent());
		if(mtfRequest != null) {
			List<MultipartFile> fileList = mtfRequest.getFiles("fileList");
			for(int i=0; i<fileList.size(); i++) {
				MultipartFile multi = fileList.get(i);
				System.out.println(multi.isEmpty());
				if (multi.isEmpty()==true) {	//업로드실패
					res =  0;
					System.out.println(res);
				}else {
					//업로드(제목글번호를 no로 가짐)
					printInfo(multi, dto.getNum());
					res=1;
					System.out.println(res);
				}
			}
		}
		if(res == 1) {
			service.insert(dto, request);
		}
		//return "redirect:/file/FList";
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
		private void printInfo(MultipartFile file, int num) {
				System.out.println("파일명 : " + file.getOriginalFilename()	//파일 실제이름 출력
						+ "\n크기(byte) : " + file.getSize());	
				String path = upload(file);
				System.out.println("업로드 된 경로 : " + path);
				
				service.addFile(num, file.getOriginalFilename(), path);
		}
		
		
		
	
	@PutMapping("/flist")
	public String update(BoardDto dto) {
		try {
			System.out.println(dto.getNum() + dto.getContent());
			service.update(dto);
		}catch(PasswordCheckException e) {
			return "redirect:/board/error";
		}
		return "redirect:/file/FList";
	}
	
	@DeleteMapping("/flist")
	public String delete(int num, String passwd, int p) {
		try {
			service.delete(num, passwd);
		}catch(PasswordCheckException e) {
			return "redirect:/board/error";
		}
		return "redirect:/file/FList";
	}
	
	//@ModelAttribute:돌려줄 모델데이터의 이름 지정하기
	@GetMapping("/fWriteForm")
	public String writeForm(@ModelAttribute("dto") BoardDto dto) {
		return "file/uploadForm";
	}
	
	@GetMapping("/fContent")
	public String content(@RequestParam(value = "p") int pageNum, int num, Model m) {
		List<FileDto> fdto = service.showFile(num);
		System.out.println(fdto.toString());
		BoardDto dto = service.getContent(num);
		m.addAttribute("fdto", fdto);
		m.addAttribute("article", dto);
		m.addAttribute("pageNum", pageNum);
		return "file/fContent";
	}
	
	@GetMapping("/fUpdateForm")
	public String updateForm(int num, int p, Model m) {
		List<FileDto> fdto = service.showFile(num);
		BoardDto dto = service.updateForm(num);
		m.addAttribute(fdto);
		m.addAttribute("article", dto);
		m.addAttribute("pageNum", p);
		return "file/fUpdateForm";
	}
	
	@GetMapping("/fError")
	public String error() {
		return "error/exception";
	}
	
	@GetMapping("/fDeleteForm")
	public String deleteForm(int num, int p, Model m) {
		m.addAttribute("num", m);
		m.addAttribute("pagrNum", p);
		return "file/fDeleteForm";
	}

	public void setService(FBoardService service) {
		this.service = service;
	}
	 
}
