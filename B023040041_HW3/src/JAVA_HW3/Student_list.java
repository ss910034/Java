package JAVA_HW3;

import java.util.ArrayList;

public class Student_list {
	int i=0;
	private ArrayList<Student_info> addinformation =new ArrayList<Student_info>();
	public void add(Student_info addi){
		addinformation.add(addi);
	}
	public int remove(String re){
		for(i=0;i<addinformation.size();i++)
		{
			if(addinformation.get(i).getName().equals(re))
			{
				addinformation.remove(i);
				return 1;
			}
		}
		if(addinformation.isEmpty())
			System.out.println("The list is empty\n");
		else
			 System.out.printf("Name %s is not in the list.\n\n",re);
		return 0;
	}
	public int remove(int re){
		for(i=0;i<addinformation.size();i++)
		{
			if(addinformation.get(i).getID()==re)
			{
				addinformation.remove(i);
				return 1;
			}
		}
		if(addinformation.isEmpty())
			System.out.println("The list is empty\n");
		else
			 System.out.printf("ID %d is not in the list.\n\n",re);
		return 0;
		
	}
	public void display(){
		if(addinformation.isEmpty())
			System.out.println("[null]");
		else
		{
			for(i=0;i<addinformation.size();i++)
			{
				System.out.printf("<%d>\n",i+1);
				addinformation.get(i).show_data();
			}
		}
	}
}
