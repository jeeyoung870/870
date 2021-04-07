package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArithmeticOperatorController {

	@RequestMapping("/math/add.do")
	public String add(@RequestParam("op1") int op1, @RequestParam("op2") int op2, Model model) {
		model.addAttribute("result", op1 + op2);
		return "math/result";
	}
	
	@RequestMapping("/math/subtract.do")
	public String subtract(@RequestParam("op1") int op1, @RequestParam("op2") int op2, Model model) {
		model.addAttribute("result", op1 - op2);
		return "math/result";
	}
	
	@RequestMapping("/math/multiply.do")
	public String multiply(@RequestParam("op1") int op1, @RequestParam("op2") int op2, Model model) {
		model.addAttribute("result", op1 * op2);
		return "math/result";
	}
	
	@RequestMapping("/math/divide.do")
	public String divide(@RequestParam("op1") int op1, @RequestParam("op2") int op2, Model model) {
		model.addAttribute("result", op1 / op2);
		return "math/result";
	}
}