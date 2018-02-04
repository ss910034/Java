// Represents a balance inquiry ATM transaction

public class BalanceInquiry extends Transaction{

	Screen sc = new Screen();
	public void execute(BankDatabase x,int user){
		sc.displayMessage("Balance Information\n");
		System.out.println("Total Balance : "+x.getTotalBalance(user)+"\n");
	}
	
}
