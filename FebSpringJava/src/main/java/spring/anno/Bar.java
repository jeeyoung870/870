package spring.anno;

import org.springframework.stereotype.Component;

@Component
public class Bar {
	
	public void doBar() {
		System.out.println("doBar() 실행");
	}
}
