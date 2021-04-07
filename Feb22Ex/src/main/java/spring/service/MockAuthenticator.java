package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.common.CommonLogger;

@Service  // = @Component
public class MockAuthenticator implements Authenticator {
	
	@Autowired
	private CommonLogger commonLogger;


	public void authenticate(LoginCommand loginCommand) throws AuthenticationException {
		if (!loginCommand.getUserId().equals(loginCommand.getPassword())) {
			commonLogger.log("인증 에러 - " + loginCommand.getUserId());
			//메소드를 호출한 지점으로 생성한 예외객체를 throw
			throw new AuthenticationException();
		}
	}

	public void setCommonLogger(CommonLogger commonLogger) {
		this.commonLogger = commonLogger;
	}

}