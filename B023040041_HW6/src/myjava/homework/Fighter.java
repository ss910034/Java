package myjava.homework;
import java.util.Scanner;
public class Fighter extends Adventure{
	public Scanner input = new Scanner(System.in);
	public Fighter(){
		super.setHp(80);
		super.setAtk(40);
		super.setUnique(10);
	}
	public int action(){
		System.out.print("(1) Brandish (2) Iron Body (3) Rage\nAction: (By default: (1)) ");
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
		System.out.print("[Brandish]: ");
		atk = (int) (Math.random()*11+this.getAtk());
		System.out.printf("%d damage.\n",atk);
		return atk;
	}
	public int defense_skill(){
		System.out.printf("[Iron Body]: DEF + %d points.\n",this.getUnique());
		this.setUnique(this.getUnique()*2);
		return 0;
	}
	public int buff_skill(){
		System.out.printf("[Rage]: ATK + %d points.\n",this.getAtk());
		this.setAtk(this.getAtk()*2);
		return 0;
	}
}
