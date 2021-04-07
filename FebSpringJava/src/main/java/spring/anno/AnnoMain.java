package spring.anno;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AnnoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context
		= new GenericXmlApplicationContext("AnnoTest.xml");
		Foo f = context.getBean("myFoo", Foo.class);
		f.printFoo();
		
		Foo scott = context.getBean("scottFoo", Foo.class);
		scott.printFoo();
		
		context.close();

	}

}
