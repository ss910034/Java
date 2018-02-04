package JAVA_HW4;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class fourStarGame {
	private ArrayList<Integer> userNums =new ArrayList<Integer>();
	private ArrayList<Integer> winNums =new ArrayList<Integer>();
	String inputs;
	Scanner input = new Scanner(System.in);
	public fourStarGame()
	{
		
	}
	public void generateUserNums(){
			System.out.print("Input four user numbers : ");
			int i=0;
			inputs=input.nextLine();
			String[] AfterSplit = inputs.split(" ");
			for(i=0;i<AfterSplit.length;i++)
				userNums.add(Integer.parseInt(AfterSplit[i]));
	}
	public void generateWinNums(){
		System.out.print("Win numbers : ");
	    int i=0,ranum;
		Random ran = new Random();
		for(i=0;i<4;i++)
		{
			ranum=ran.nextInt(9)+1;
			if(!(winNums.contains(ranum)))
			{
				winNums.add(ranum);
			}
			else
				i--;
		}
		for(i=0;i<winNums.size();i++)
		{
			System.out.printf("%d ",winNums.get(i));
		}
		System.out.println();
	}
	public ArrayList<Integer> getUserNums(){
		return userNums;
	}
	public ArrayList<Integer> getWinNums(){
		return winNums;
	}
}
