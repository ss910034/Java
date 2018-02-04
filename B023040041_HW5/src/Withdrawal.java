// Represents a withdrawal ATM transaction

public class Withdrawal extends Transaction{
	Screen sc = new Screen();
	Keypad in = new Keypad();
	private int amount;
	public void execute(BankDatabase x,int user){
		sc.displayMessage("How much do you want to withdraw : ");
		amount = in.getInput();
		if( amount >= 0 )
		{
			if(x.getTotalBalance(user) < amount)
				System.out.println("ERROR! You withdraw too much.\n");
			else
			{
				x.debit(amount,user);
				sc.displayMessage("Success\n\n");
			}
		}
		else
			sc.displayMessage("Error Input.\nPlease try again.\n\n");
	}

}
