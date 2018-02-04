package myjava.homework;

public class information {
	private String account;
	private int password;
	private int money;
	public information(String x,int y, int z){
		account = x;
		password = y;
		money = z;
	}
	public String getAccount(){
		return account;
	}
	public int getPassword(){
		return password;
	}
	public int getMoney(){
		return money;
	}
	
}
