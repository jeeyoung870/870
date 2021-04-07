package Account;

public class Account {
	private long balance;
	
	public Account() {}
	
	public long getBalance() {
		return balance;
	}
	public void deposit (int money) {	//입금
		balance += money;
	}
	public void withdraw (int money) throws BalanceInsufficientException {//출금
		if (balance < money) {
			throw new BalanceInsufficientException("잔고부족:"+(money-balance)+"원 모자람");
		}	//사용자 정의 예외 발생 - catch 블록에서 getMessage()메소드 리턴값으로 받을 수 있음
		balance -= money;
	}

}
