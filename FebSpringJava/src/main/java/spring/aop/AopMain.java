package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext context
		 = new GenericXmlApplicationContext("AopTest.xml");
		
		GreetingService greeting = context.getBean("greeting", GreetingServiceImpl.class);
		greeting.sayHello("이자바");
		try {
			greeting.sayGoodbye("김자바");
		} catch(Exception e){
			System.out.println("catch");
			//e.printStackTrace();
		}
		

	}

}
