package board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardDto;
import board.model.BoardListModel;
import board.service.BoardService;
import board.service.PasswordCheckException;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	 
	@GetMapping("/list")
	public String list(@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "per", defaultValue = "4") int per, Model m) {
		
		BoardListModel list = service.list(pageNum, per);
		list.setPer(per);
		m.addAttribute("list", list);
		m.addAttribute("per", per);
		int number = list.getCount() - (pageNum - 1) * per;
		m.addAttribute("number", number);
		return "list"; 
	}
	
	@PostMapping("/list")
	public String write(BoardDto dto, HttpServletRequest request) {
		System.out.println(dto.getSubject());
		service.insert(dto, request);
		return "redirect:/board/list";
	}
	
	@PutMapping("/list")
	public String update(BoardDto dto) {
		try {
			System.out.println(dto.getNum() + dto.getContent());
			service.update(dto);
		}catch(PasswordCheckException e) {
			return "redirect:/board/error";
		}
		return "redirect:/board/list";
	}
	
	@DeleteMapping("/list")
	public String delete(int num, String passwd, int p) {
		try {
			service.delete(num, passwd);
		}catch(PasswordCheckException e) {
			return "redirect:/board/error";
		}
		return "redirect:/board/list";
	}
	
	//@ModelAttribute:돌려줄 모델데이터의 이름 지정하기
	@GetMapping("/writeForm")
	public String writeForm(@ModelAttribute("dto") BoardDto dto) {
		return "writeForm";
	}
	
	@GetMapping("/content")
	public String content(@RequestParam(value = "p") int pageNum, int num, Model m) {
		BoardDto dto = service.getContent(num);
		m.addAttribute("article", dto);
		m.addAttribute("pageNum", pageNum);
		return "content";
	}
	
	@GetMapping("/updateForm")
	public String updateForm(int num, int p, Model m) {
		BoardDto dto = service.updateForm(num);
		m.addAttribute("article", dto);
		m.addAttribute("pageNum", p);
		return "updateForm";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error/exception";
	}
	
	@GetMapping("/deleteForm")
	public String deleteForm(int num, int p, Model m) {
		m.addAttribute("num", m);
		m.addAttribute("pagrNum", p);
		return "deleteForm";
	}

	public void setService(BoardService service) {
		this.service = service;
	}

}
