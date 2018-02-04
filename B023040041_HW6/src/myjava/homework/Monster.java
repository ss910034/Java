package myjava.homework;

public class Monster extends Adventure{

	public Monster(){
		super.setHp((int)(Math.random()*151)+150);
		super.setAtk((int)(Math.random()*6)+30);
	}
	public int action() {
		int atk=(int)(Math.random()*11)+super.getAtk();
		System.out.printf("[Monster]: %d damage.\n",atk);
		return atk;
	}

}
