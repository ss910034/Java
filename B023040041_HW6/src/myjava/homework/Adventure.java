package myjava.homework;

public abstract class Adventure {
	private int hp;
	private int atk;
	private int unique;
	public int getHp(){
		return hp;
	}
	public int getAtk(){
		return atk;
	}
	public int getUnique(){
		return unique;
	}
	public void setHp(int x){
		hp=x;
	}
	public void setAtk(int x){
		atk=x;
	}
	public void setUnique(int x){
		unique=x;
	}
	public abstract int action();
}
