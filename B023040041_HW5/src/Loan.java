public class Loan extends Transaction{
	Screen sc = new Screen();
	Keypad in = new Keypad();
	private int amount;
	public void execute(BankDatabase x,int user){
		int canloadmoney = 0;
		switch(x.getCreditLevel(user)){
		case 'A':
			canloadmoney = 12000;
			break;
		case 'B':
			canloadmoney = 9000;
			break;
		case 'C':
			canloadmoney = 7000;
			break;
		default:
			sc.displayMessage("Error input!");
		}
		canloadmoney -= x.getDebt(user);
		System.out.printf("Your debt : %d\n",x.getDebt(user));
		System.out.printf("Your loan limit is %d , how much do you want to loan : ",canloadmoney);
		amount = in.getInput();
		if( amount >=0 ){
			if( amount <= canloadmoney){
				x.loan(amount,user);
				sc.displayMessage("Transaction Success.\n\n");
			}
			else
				sc.displayMessage("Transaction Error, You have not much Loan Limit.\n\n");
		}
		else
			sc.displayMessage("Error Input.\nPlease try again.\n\n");
		
	}

}
