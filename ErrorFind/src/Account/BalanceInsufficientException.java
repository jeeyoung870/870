package Account;
//모든 예외 객체는 Exception 클래스를 상속함.(예외클래스 만들기)
//Exception이 가지고 있는 메소드들을 모든 예외 객체에서 호출할 수 있다.
//getMessage(), printStackTrace() 등등...
public class BalanceInsufficientException extends Exception {
	public BalanceInsufficientException() {}
	public BalanceInsufficientException(String msg) {
		super(msg);
	}

}
