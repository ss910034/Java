//Represents a bank account

public class Account {
	private int accountNumber;
	private int pin;
	private int totalBalance;
	private int debt = 0;
	private char creditLevel;
	
	public Account(int ac,int pi,int to,char cr){
		accountNumber = ac;
		pin = pi;
		totalBalance = to;
		creditLevel = cr;
	}
	public boolean validatePIN(int x)
	{
		if(x == pin)
			return true;
		else
			return false;
	}
	public int getAccountNumber(){
		return accountNumber;
	}
	public int gettotalBalance(){
		return totalBalance;
	}
	public char getcreditLevel(){
		return creditLevel;
	}
	public int getdebt(){
		return debt;
	}
	public void credit(int x){
		totalBalance += x;
	}
	public void debit(int x){
			totalBalance -= x;
	}
	public void loan(int x){
		debt += x;
	}
}
