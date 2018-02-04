import java.util.Scanner;

public class ATM {

	private boolean userAuthenticated;
	public Scanner input;
	Screen sc = new Screen();
	public void run(){
		while(true){
			int user,pass,choose,logout=0;
			Keypad in = new Keypad();
			BankDatabase ac = new BankDatabase();
			sc.displayMessage("Welcome ! \n");
			sc.displayMessage("Please enter your account number : ");
			user = in.getInput();
			if( user == -999 )
			{
				System.out.println("Error! Wrong input,please try again.");
				continue;
			}
			sc.displayMessage("Please enter pin : ");
			pass = in.getInput();
			if( pass == -999 )
			{
				System.out.println("Error! Wrong input,please try again.");
				continue;
			}
			if( ac.authenticateUser(user,pass) == true )
			{
				System.out.println();
				while(true){
					sc.displayMessage("Main_menu:\n1.View my balance\n2.Withdraw\n3.Deposit\n4.Loan\n5.Exit\nEnter a coice : ");
					choose = in.getInput();
					switch(choose)
					{
					case 1:
						BalanceInquiry tb = new BalanceInquiry();
						tb.execute(ac,user);
						break;
					case 2:
						Withdrawal withmoney = new Withdrawal();
						withmoney.execute(ac,user);
						break;
					case 3:
						Deposit save = new Deposit();
						save.execute(ac,user);
						break;
					case 4:
						Loan loanmoney = new Loan();
						loanmoney.execute(ac,user);
						break;
					case 5:
						System.out.println("Bye~\n");
						logout=1;
						break;
					}
					if(logout==1)
						break;
				}
			}
			else
				System.out.println("Login failed!Please login again.");
		}
	}
}
