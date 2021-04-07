package Account;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <SavingAccount> sa =  new ArrayList <SavingAccount>();
		SavingAccount sa1 = new SavingAccount("김어쩌구", 1000000);
		SavingAccount sa2 = new SavingAccount ("박어쩌구", 5000000);
		SavingAccount sa3 = new SavingAccount("이어쩌구", 2000000);
		
		sa.add(sa1);
		sa.add(sa2);
		sa.add(sa3);
		
		SavingAccount.setInterestRate(0.005);
		
		for (SavingAccount e : sa) {
			e.displayAccount();
		}
		sa1.withdraw(50000);
		sa1.withdraw(4000);
		sa2.withdraw(600000);
		
		
	}

}
