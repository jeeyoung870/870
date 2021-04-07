package view.service;

import org.springframework.stereotype.Service;

@Service	//("mockAuthenticator_view")
public class MockAuthenticator implements Authenticator {

	@Override
	public void authenticate(String id, String password) {
		if (!id.equals("test")) {
			throw new AuthenticationException("invalid id "+id);
		}
	}

}