package spring.anno;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Setter;

//lombok.jar로 세터 자동생성
//@Setter
@Component("myFoo")
public class Foo {
	//@Resource
	//@Autowired
	//@Qualifier("aaa")
	Bar bar;
	
	int i;
	@Value("jyjy")
	String name;
	
	
	@Value("10")
	public void setI(int i) {
		this.i = i;
	}
	//@Value("문자열 저장")   필드에 붙인느것보다 메소드에 붙이는게 우선순위 높음.
	public void setName(String str) {
		this.name = str;
	}

	@Autowired
	//@Qualifier("aaa")
	//@Required
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	
	public void printFoo() {
		System.out.println("printFoo() 실행");
		System.out.println("name : " + name);
		bar.doBar();
	}
	
	@PostConstruct
	public void start() { 
		System.out.println("start 실행");
	}
	@PreDestroy
	public void stop() { 
		System.out.println("stop 실행");
	}
	

}
