package JAVA_HW4;

import java.util.ArrayList;

public class Permutation extends fourStarGame {

	public void checkOfWin(){
		int i=0,has=0;
		try{
			generateWinNums();
			generateUserNums();
			ArrayList<Integer> win = getWinNums();
			ArrayList<Integer> user = getUserNums();
			if(user.size()<4)
				System.out.println("Wrong input, try again.");
			else
			{
				for(i=0;i<4;i++)
				{
					if(win.get(i)!=user.get(i))
					{
						has++;
						break;
					}
				}
				if(has>0)
					System.out.println("**You lose!");
				else
					System.out.println("**You win!");
			}
		}
		catch( Exception e)
		{
			 System.out.println("Wrong input, try again.");
		}
	}
}
