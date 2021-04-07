package UserException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			foo();
		}catch (UserException e) {
			System.out.println(e.getMessage() + "from main()");
		}

	}

	public static void foo() throws UserException {
		try {
			//....
			//if condition
			throw new UserException(5);
			//...
		}catch (UserException e) {
			System.out.println(e.getMessage() + "from foo()");
			throw e;
		}
	}
}
