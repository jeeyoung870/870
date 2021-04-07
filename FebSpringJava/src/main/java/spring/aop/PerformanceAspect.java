package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {
	
	@Pointcut("execution(public * spring.aop.*.sayHello(..))")
	private void pointCut() {}
	
	
	//around처리할 메소드 구현
	@Around("pointCut()")
	public Object timeCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		//ProceedingJoinPoint : JoinPoint인터페이스를 상속받음.대상객체, 메소드, 파라미터정보값을 가지고있음.
		//joinPoint : 핵심로직 메소드 객체
		Signature s= joinPoint.getSignature();
		String methodName = s.getName();	//메소드이름 가져오기
		
		long startTime = System.nanoTime();	//시작시간 재기
		System.out.println("[Log]METHOD Before : " + methodName+" time check start"); 
		Object obj = null;
		
		try{
			//proceed() : 핵심로직인 메소드(sayHello())를 찾아가 실행함.없으면 null리턴
			obj = joinPoint.proceed();
		}catch(Exception e){
			System.out.println("[Log]METHOD error : "+ methodName);
		}
		
		 long endTime = System.nanoTime();	//종료시간 재기
		 System.out.println("[Log]METHOD After : " + methodName+" time check end");
		 System.out.println("[Log] "+ methodName + " Processing time is "+(endTime - startTime)+"ns");
		 return obj;
	}       

}
