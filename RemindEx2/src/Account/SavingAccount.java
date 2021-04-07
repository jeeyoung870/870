package Account;

public class SavingAccount {
	private String name;
	private int amount;
	private static double interestRate = 0.001;
	
	
	public SavingAccount (String name, int amount) {
		this.name = name;
		this.amount = amount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public static void setInterestRate(double interestRate) {
		SavingAccount.interestRate = interestRate;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public double getInterest() {
		return amount*interestRate;
	}
	
	public void displayAccount() {
		System.out.printf("이름 : %s  잔액 : %d원  이자 : %f원\n", getName(), getAmount(), getInterest());
	}
	
	public int withdraw (int money) {
		if(money > amount) {
			System.out.printf("잔액이 %d원 부족합니다.\n", money-amount);
		} else {
			amount -= money;
			System.out.printf("%s님 %d원 출금 - 잔액 : %d원\n", name, money, amount);
		}
		return amount;
	}
	

}
