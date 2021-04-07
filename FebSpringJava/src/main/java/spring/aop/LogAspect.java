package spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//Aspect(Advice)
@Component
@Aspect
public class LogAspect {
	
	@Pointcut("execution(* spring.aop.*.*bye(..))")
	private void pointCut() {}
	
	
	//매개변수가 없는 before
	@Before("pointCut()")
	public void beforeLogging(){
		System.out.println("** 메서드 호출 전**");
	}
	
	//매개변수로 리턴값을 가짐. <aop:after-returning>태그
	@AfterReturning(pointcut = "pointCut()", returning ="returnValue" )
	public void afterLogging(Object returnValue){
		System.out.println("** 메서드 호출 후**");
	}   
	//<aop:after-throwing>태그
	@AfterThrowing(pointcut = "pointCut()", throwing = "ex")
	public void throwingLogging(Exception ex){
		System.out.println("** 예외 발생 : "+ex.getMessage()+"**");
	}
	//<aop:after>태그
	@After("pointCut()")
	public void alwaysLogging(){
		System.out.println("** 항상 실행 **");      
	}

}
