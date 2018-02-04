package myjava.homework;

import java.util.HashSet;

public class User {
	private String username;
	public HashSet<User> friends = new HashSet<User>();
	public User(String s){
		username = s;
	}
	public String getname(){
		return username;
	}
	public String toString(){
		return String.format("(%s)",this.username);
	}
}
