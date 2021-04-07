package spring.chap01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForAop {
	public static void main(String[] args) {
		//설정파일xml이 여러개인 경우 배열로 입력한다.
		String[] configLocations = new String[] { "applicationContext.xml", "commonConcern.xml" };
		//설정정보를 객체로 가지는 container 가 생성됨
		ApplicationContext context = new GenericXmlApplicationContext(configLocations);
		
		
		WriteArticleService articleService 
		//object타입으로 가져오는 getBean메소드에 WriteArticleService.class로 타입캐스팅해서 가져옴
		= context.getBean("writeArticleService",WriteArticleService.class);
		articleService.write(new Article());
		
		
	}
}