package spring.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import spring.model.DeptDto;
import spring.model.EmpDto;
import spring.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	EmpService emp;

	//@RequestMapping(value = "/emp/empInfo.do")
	@GetMapping(value = "/emp/empInfo.do")
	public String emp() throws Exception {
		return "emp/empInfo";
	}

	//ajax요청에 따라 select * from dept의 결과 list를 json형식으로 돌려준다.
	//HttpServletResponse resp : 메소드가 끝나면 resp(response객체)를 그대로 돌려준다.(첫번째 방법)
	@RequestMapping(value = "/emp/depts.do", method = RequestMethod.POST)
	// = @PostMapping(value = "/emp/depts.do")
	public void deptList(HttpServletResponse resp) throws Exception {
		List<DeptDto> list = emp.selectDepts();
		Gson json = new Gson(); 		//java -> json
		resp.setContentType("text/html;charset=utf-8");		//응답정보 결과물 설정
		PrintWriter out = resp.getWriter(); 	//response객체에 데이터를 출력하는 스트림 연결
		out.print(json.toJson(list));
		//System.out.println(json.toJson(list));
	}

	@RequestMapping(value = "/emp/emps.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody  // -->리턴되는 데이터가 response객체에 담겨 클라이언트로 돌아간다.(두번째 방법)
	public String empList(int deptno) throws Exception {
		//int deptno = ajax요청을 통해 넘어온 parameter값의 이름이 같으면 자동으로 대입된다.(이름다르면 @RequestParam어노테이션 사용)
		List<Map<String,Object>> list = emp.selectEmps(deptno);
		Gson json = new Gson(); 
		//System.out.println(json.toJson(list));
		//부서번호로 검색한 ename을 리턴함
		return json.toJson(list);	//Map객체들이 저장된 list반환
	}

	@RequestMapping(value = "/emp/empOne.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String empOne(int empno) throws Exception {
		EmpDto list = emp.selectEmpOne(empno);
		Gson json = new Gson(); 		
		return json.toJson(list);
	}

	public void setEmp(EmpService emp) {
		this.emp = emp;
	}

}