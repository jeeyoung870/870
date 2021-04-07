package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//POST방식으로 요청 처리
@RestController
public class SimpleConverterController {
//@RequestBody : 문자열, byte, Map형식으로 가져올 수 있음(각각 "/test/simpleTest.do", "/test/simpleTest1.do", "/test/simpleTest2.do")
	@RequestMapping(value = "/test/simpleTest.do", method = RequestMethod.POST , produces="text/plain;charset=UTF-8")
	public String simpleTest(@RequestBody String body,String name,String age) {
		System.out.println(name+ " "+age);
		/* System.out.println(body); */
		return body;
	}

	@RequestMapping(value = "/test/simpleTest1.do", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public byte[] simpleTest1(@RequestBody byte[] body) {
		return body;
	}

	@RequestMapping(value = "/test/simpleTest2.do", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String simpleTest2(@RequestBody MultiValueMap<String, String> body) {
		return body.toString();
	}
}


