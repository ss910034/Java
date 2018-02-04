package homework.part1;

public class StudentInformation {
	private String id;
	private String name;
	private int score;
	public StudentInformation(String idi,String namei,int scorei){
		id=idi;
		name=namei;
		score=scorei;
	}
	public void setData(String i,String n,int sco){
		name=n;
		id=i;
		score=sco;
	}
	public String getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	public int getScore(){
		return score;
	}
	public void show_data(){
		System.out.printf("Student id : %s\n",id);
 		System.out.printf("Student name : %s\n",name);
 		if(score>=60)
 			System.out.printf("Student %s pass this project\n",name);
 		else
 			System.out.printf("Student %s fail this project\n",name);
	}
}
