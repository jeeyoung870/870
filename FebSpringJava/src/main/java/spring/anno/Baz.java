package spring.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class Baz {
	
	@Bean
	public Foo scottFoo() {
		Foo foo = new Foo();
		foo.setName("scott");
		return foo;
	}

}
