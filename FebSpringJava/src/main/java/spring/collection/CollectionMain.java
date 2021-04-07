package spring.collection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext con
		= new GenericXmlApplicationContext("CollTest.xml");
		CollectionEx c = con.getBean("Collection", CollectionEx.class);
		System.out.println(c);
		
		con.close();
		

	}

}
