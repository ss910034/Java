package myjava.homework;
import java.util.Scanner;
public class Hw6_main {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
			while(true){
				
				Adventure ad = null;
				Monster mon = new Monster();
				int uatk,matk;
				System.out.println("(1) Fighter\t(2) Magician\t(3) Archer");
				System.out.print("Choose your character (By default: (1)) : ");
				String choose = input.next();
				System.out.println("[Monster appeared!]");
				switch(choose){
				case "2":
					ad = new Magician();
					System.out.printf("----Adventurer----\t----Monster----\n  HP: %3d\t\t  HP: %3d\n  ATK: %3d\t\t  ATK: %3d\n  ES: %3d\n------------------\t---------------\n",ad.getHp(),mon.getHp(),ad.getAtk(),mon.getAtk(),ad.getUnique());
					while(ad.getHp()>0 && mon.getHp()>0)
					{
						uatk = ad.action();
						mon.setHp(mon.getHp()-uatk);
						matk=mon.action();
						if(matk <= ad.getUnique())
						{
							System.out.printf("[Energy Shield]: Shield - %3d points.\n",matk);
							ad.setUnique(ad.getUnique()-matk);
						}
						else{
							System.out.printf("[Energy Shield]: Shield - %3d points.\n",ad.getUnique());
							ad.setUnique(0);
							int rhp = matk - ad.getUnique();
							if(rhp>0)
								ad.setHp(ad.getHp()-rhp);
							else
								rhp = 0;
							System.out.printf("[Magician]: HP - %d points.\n",rhp);
						}
						if(ad.getHp() < 0)
							ad.setHp(0);
						if(mon.getHp() < 0)
							mon.setHp(0);
						System.out.printf("----Adventurer----\t----Monster----\n  HP: %3d\t\t  HP: %3d\n  ATK: %3d\t\t  ATK: %3d\n  ES: %3d\n------------------\t---------------\n",ad.getHp(),mon.getHp(),ad.getAtk(),mon.getAtk(),ad.getUnique());
					}
					break;
				case "3":
					ad = new Archer();
					System.out.printf("----Adventurer----\t----Monster----\n  HP: %3d\t\t  HP: %3d\n  ATK: %3d\t\t  ATK: %3d\n  EVA: %3d\n------------------\t---------------\n",ad.getHp(),mon.getHp(),ad.getAtk(),mon.getAtk(),ad.getUnique());
					while(ad.getHp()>0 && mon.getHp()>0)
					{
						uatk = ad.action();
						mon.setHp(mon.getHp()-uatk);
						matk=mon.action();
						int p = (int) (Math.random()*100);
						if( p <= ad.getUnique() ){
							System.out.println("Evasion succeed!");
						}
						else{
							ad.setHp(ad.getHp()-matk);
							System.out.printf("[Archer]: HP - %d points.\n",matk);
						}
						if(ad.getHp() < 0)
							ad.setHp(0);
						if(mon.getHp() < 0)
							mon.setHp(0);
						System.out.printf("----Adventurer----\t----Monster----\n  HP: %3d\t\t  HP: %3d\n  ATK: %3d\t\t  ATK: %3d\n  EVA: %3d\n------------------\t---------------\n",ad.getHp(),mon.getHp(),ad.getAtk(),mon.getAtk(),ad.getUnique());
					}
					break;
				default:
					ad = new Fighter();
					System.out.printf("----Adventurer----\t----Monster----\n  HP: %3d\t\t  HP: %d\n  ATK: %3d\t\t  ATK: %3d\n  DEF: %3d\n------------------\t---------------\n",ad.getHp(),mon.getHp(),ad.getAtk(),mon.getAtk(),ad.getUnique());
					while(ad.getHp()>0 && mon.getHp()>0)
					{
						uatk = ad.action();
						mon.setHp(mon.getHp()-uatk);
						matk=mon.action();
						int rhp = matk - ad.getUnique();
						if(rhp>0)
							ad.setHp(ad.getHp()-rhp);
						else
							rhp = 0;
						System.out.printf("[Fighter]: HP - %d points.\n",rhp);
						if(ad.getHp() < 0)
							ad.setHp(0);
						if(mon.getHp() < 0)
							mon.setHp(0);
						System.out.printf("----Adventurer----\t----Monster----\n  HP: %3d\t\t  HP: %3d\n  ATK: %3d\t\t  ATK: %3d\n  DEF: %3d\n------------------\t---------------\n",ad.getHp(),mon.getHp(),ad.getAtk(),mon.getAtk(),ad.getUnique());
					}
					break;
				}
				if( ad.getHp()==0 ){
					System.out.println("You lose....\n");
				}
				else if( mon.getHp() == 0 )
					System.out.println("You win....\n");
			}
	}
}
