// Represents the bank account information database

public class BankDatabase {
	
	private Account[] accounts; // array of Accounts
    // no-argument BankDatabase constructor initializes accounts
	public BankDatabase () {
		accounts = new Account[3];  // just 3 accounts for testing
		accounts[0] = new Account(123, 321, 5000,'A');
		accounts[1] = new Account(456, 654, 3000,'B');
		accounts[2] = new Account(789, 987, 1000,'C');
	}
	public boolean authenticateUser(int x,int y){
		int i=0,has=0;
		for(i=0;i<3;i++){
			if( accounts[i].getAccountNumber() ==x && accounts[i].validatePIN(y)==true ){
				return true;
			}
		}
		return false;
	}
	public int getTotalBalance(int x){
		int i=0;
		for(i=0;i<3;i++){
			if( accounts[i].getAccountNumber() ==x ){
				break;
			}
		}
		return accounts[i].gettotalBalance();
	}
	public int getCreditLevel(int x){
		int i=0;
		for(i=0;i<3;i++)
			if( accounts[i].getAccountNumber() == x )
				break;
		return accounts[i].getcreditLevel();
	}
	public int getDebt(int x){
		int i=0;
		for(i=0;i<3;i++)
			if( accounts[i].getAccountNumber() == x )
				break;
		return accounts[i].getdebt();
	}
	public void credit(int x,int user){
		int i=0;
		for(i=0;i<3;i++)
			if( accounts[i].getAccountNumber() ==user )
				break;
		accounts[i].credit(x);
	}
	public void debit(int x,int user){
		int i=0;
		for(i=0;i<3;i++)
			if( accounts[i].getAccountNumber() ==user )
				break;
		accounts[i].debit(x);
	}
	public void loan(int x,int user){
		int i=0;
		for(i=0;i<3;i++)
			if( accounts[i].getAccountNumber() ==user )
				break;
		accounts[i].loan(x);
	}
	
	
}
