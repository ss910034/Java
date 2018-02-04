package homework.part2;

import java.util.ArrayList;

public class ItemList {
	private ArrayList<String> id=new ArrayList<String>();
	public void addItem(String item)
	{
		id.add(item);
	}
	public void remove(String item)
	{
		id.remove(item);
	}
	public void printList(){
		int i;
		for(i=0;i<id.size();i++)
		{
			System.out.printf("%d : %s\n",i+1,id.get(i));
		}
	}
}
