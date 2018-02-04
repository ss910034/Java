public class Deposit extends Transaction{
	Screen sc = new Screen();
	Keypad in = new Keypad();
	private int amount;
	public void execute(BankDatabase x,int user){
		sc.displayMessage("How much do you want to deposit : ");
		amount = in.getInput();
		if( amount >= 0 ){
			x.credit(amount,user);
			sc.displayMessage("Success\n\n");
		}
		else
			sc.displayMessage("Error Input.\nPlease try again.\n\n");
	}

}
