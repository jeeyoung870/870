package spring.common;

import org.springframework.stereotype.Component;

@Component
public class CommonLoggerImpl implements CommonLogger {
	
	public void log(String message) {
		System.out.println("CommonLogger - " + message);
	}

}