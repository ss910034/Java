package JAVA_HW3;

public class Student_info {
	private String name;
	private int id;
	public Student_info(String n, int i)
	{
		name=n;
		id=i;
	}
	public void show_data(){
		System.out.printf("Name : %s\n",getName());
		System.out.printf("ID : %d\n",getID());
	}
	public String getName(){
		return name;
	}
	public int getID(){
		return id;
	}
}
