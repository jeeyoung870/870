package spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Setter;

//핵심로직
@Component("greeting")
public class GreetingServiceImpl implements GreetingService {
	
	@Setter
	@Value("안녕")
	private String greeting;
	
	public void sayHello(String name) {
		System.out.println("sayHello : "+ greeting + " : " + name);
	}
	
	public void sayGoodbye(String name)  {
		System.out.println("sayGoodbye : "+greeting+":"+name);
		//throw new Exception("강제로 만든 예외입니다.");
	}

}
