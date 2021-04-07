package spring.chap01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
	public static void main(String[] args) {
		ApplicationContext beanFactory 
		= new GenericXmlApplicationContext("applicationContext.xml"); //빈 2개짜리 container생성됨
		WriteArticleService articleService 
		//빈의 id값으로 꺼내오기
		= (WriteArticleService) beanFactory.getBean("writeArticleService");
		articleService.write(new Article());
	}
}
