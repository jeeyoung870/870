package spring.chap01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component("logging")
public class LoggingAspect {
	
	private Log log = LogFactory.getLog(getClass());
	
	//joinPoint : 실제로 실행한 write()메소드
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("기록 시작");
		StopWatch stopWatch = new StopWatch();
		try {
			stopWatch.start();
			Object retValue = joinPoint.proceed();
			return retValue;
		} catch (Throwable e) {
			throw e;
		} finally {
			stopWatch.stop();
			log.info("기록 종료");
			log.info(joinPoint.getSignature().getName() + "실행 시간 : " + stopWatch.getTotalTimeMillis());
		}
	}
}

