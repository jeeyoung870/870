package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DiMain {

	public static void main(String[] args) {
		// 컨텍스트(어플리케이션)에 적용할 xml설정파일 가져오기 
		//ApplicationContext context = new GenericXmlApplicationContext("DiTest.xml");
		AbstractApplicationContext context = new GenericXmlApplicationContext("DiTest.xml");
		//﻿getBean("객체명", 가져올 bean객체가 속하는 클래스명.class);
		Foo foo = context.getBean("foo", Foo.class);
		foo.doFoo();
		//foo.doFooBaz();	//lookup메소드로 주입
		
		context.close();
	}
}
