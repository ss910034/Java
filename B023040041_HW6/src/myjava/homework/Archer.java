package myjava.homework;

import java.util.Scanner;

public class Archer extends Adventure{
	private int CRI;
	public Scanner input = new Scanner(System.in);
	public Archer(){
		super.setHp(70);
		super.setAtk(60);
		super.setUnique(40);
		CRI = 0;
	}
	public int action(){
		System.out.print("(1) Arrow Blow (2) Evasion Boost (3) Critical Shot\nAction: (By default: (1)) ");
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
		int atk = 0,p= (int) (Math.random()*100);
		atk = (int) (Math.random()*11+(this.getAtk()));
		if( p < this.CRI )
			atk*=2;
		System.out.printf("[Arrow Blow]: %d damage.\n",atk);
		return atk;
	}
	public int defense_skill(){
		if( this.getUnique()*2 >= 100 )
			this.setUnique(100);
		else
			this.setUnique(this.getUnique()*2);
		System.out.printf("[Evasion Boost]: EVA: %d %%\n",this.getUnique());
		
		return 0;
	}
	public int buff_skill(){
		if( CRI < 100 )
			CRI+=25;
		System.out.printf("[Critical Shot]: CRI: %d %%\n",CRI);
		return 0;
	}
	
}
