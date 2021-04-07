package Account;

public class AccountExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		//예금하기
		account.deposit(10000);
		System.out.println("예금액 : " + account.getBalance());
		//출금하기
		try {
			account.withdraw(30000);	//입금액보다 큰 금액 출금 (예외처리)
		}catch (BalanceInsufficientException e) {
			String msg = e.getMessage();
			System.out.println(msg);
			System.out.println();
			e.printStackTrace();	//예외처리를 하고 나서도 문제가 되는 에러코드를 찾아내줌.
		}finally {
			System.out.println("감사합니다.");
		}
		System.out.println("예금액 : " + account.getBalance());

	}

}
