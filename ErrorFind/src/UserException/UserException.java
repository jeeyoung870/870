package UserException;

public class UserException extends Exception {
	private static String [] messages;
	static {
		messages = new String [10];
		for (int i = 0; i < 10; ++i) {
			messages[i] = "에러메시지" + i;
		}
	}
	private int code;
	
	public UserException (int code) {
		this.code = code;
	}
	
	public String getMessages () {
		return messages[code];
	}

}
