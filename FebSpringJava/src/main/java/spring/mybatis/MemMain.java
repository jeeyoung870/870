package spring.mybatis;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

public class MemMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext context
		 = new GenericXmlApplicationContext("MybatisTest.xml");
		//@Service로 설정한memService 가져오기
		MemService ser = context.getBean("memService", MemService.class);
		//ser.addMems();
		//ser.addMem();
		ser.members();
		
		context.close();
	}

}
