package spring.service;

public interface Authenticator {

	void authenticate(LoginCommand loginCommand)
			throws AuthenticationException;

}