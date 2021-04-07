package spring.bookstore;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CustMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext context
		= new GenericXmlApplicationContext("BookSTest.xml");
		
		CustService ser = context.getBean("custService", CustService.class);
		ser.addCust();
		ser.allCust();
		//ser.orderList1();
		
		context.close();

	}

}
