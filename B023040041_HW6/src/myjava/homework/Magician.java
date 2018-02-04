package myjava.homework;

import java.util.Scanner;

public class Magician extends Adventure {
	public Scanner input = new Scanner(System.in);
	public Magician(){
		super.setHp(40);
		super.setAtk(20);
		super.setUnique(0);
	}
	public int action(){
		System.out.print("(1) Cold Beam (2) Energy Shield (3) Heal\nAction: (By default: (1)) ");
		int atk=0;
		String choose = input.next();
		switch(choose){
		case "1":
			atk=atack_skill();
			break;
		case "2":
			defense_skill();
			break;
		case "3":
			buff_skill();
			break;
		default :
			atk=atack_skill();
			break;	
		}
		return atk;
	}
	public int atack_skill(){
		int atk=0;
		System.out.print("[ColdBeam]: ");
		atk = (int) (Math.random()*11+(this.getAtk()*4));
		System.out.printf("%d damage.\n",atk);
		return atk;
	}
	public int defense_skill(){
		int ES = (int) (Math.random()*11+(this.getAtk()*4));
		System.out.printf("[Energy Shield]: Shield + %d points\n",ES);
		this.setUnique(ES);
		return 0;
	}
	public int buff_skill(){
		int healhp=(int) (Math.random()*11)+(this.getAtk()*2);
		System.out.printf("[Heal]: HP + %d points.\n",healhp);
		if(this.getHp()+healhp>=40){
			this.setHp(40);
		}
		else
			this.setHp(this.getHp()+healhp);
		return 0;
	}
}
