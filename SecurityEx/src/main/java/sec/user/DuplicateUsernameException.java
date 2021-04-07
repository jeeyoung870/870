package sec.user;

public class DuplicateUsernameException extends RuntimeException {

	public DuplicateUsernameException(String msg, Exception ex) {
		super(msg, ex);
	}

}
