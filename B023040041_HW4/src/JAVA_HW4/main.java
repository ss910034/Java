package JAVA_HW4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
	private static Scanner input;
	public static void main(String[] args) {
		while(true)
		{
			try{
				input = new Scanner(System.in);
				System.out.println("Choose your Four Star Game type : (1.Permutation 2.Combination 3.Exit)");
				int choose = input.nextInt();
				switch(choose)
				{
					case 1:
						Permutation gamep = new Permutation();
						gamep.checkOfWin();
						break;
					case 2:
						Combination gamec = new Combination();
						gamec.checkOfWin();
						break;
					case 3:
						System.out.println("Bye~\nSee you soon!");
						System.exit(0);
						break;
					default :
						System.out.println("Wrong choose, try input again.");
						break;
				}
				
			}
			catch (InputMismatchException ex)
	        {
				System.out.println("Wrong choose, try input again.");
	        }
		}
	}
}
