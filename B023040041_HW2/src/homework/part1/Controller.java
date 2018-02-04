package homework.part1;

import java.util.Scanner;

public class Controller {
	
	public static void main(String[] args) {
		StudentInformation[] student = new StudentInformation[10000];
		String inputname = null,inputid,choose="";
		int inputscore=0,num=0,i;
		Scanner input =new Scanner(System.in);
		while(true)
		{
			int pass=0,nopass=0;
			System.out.println("Type 1 : add a student's data(student ID,student name and score)");
			System.out.println("Type 2 : show student's data");
			System.out.println("Type 3 : show all student's data.");
			if(input.hasNext())
				choose = input.next();
			else
			{
				System.out.println("Bye~");
				break;
			}
		 	switch(choose){
		 	case "1":
		 		System.out.print("Add new student's data :\nstudent id : ");
		 		inputid=input.next();
		 		System.out.print("student name : ");
		 		inputname = input.next();
		 		System.out.print("Score : ");
		 		inputscore = input.nextInt();
		 		System.out.printf("This is student %d\n\n", num+1);
		 		student[num]= new StudentInformation(inputid,inputname,inputscore);
		 		num++;
		 		break;
		 	case "2":
		 		System.out.print("To show which student's information : \n");
		 		int studentnum=input.nextInt();
		 		if(studentnum>num)
		 			System.out.println("Data no found\n");
		 		else
		 		{
		 			student[studentnum-1].show_data();
			 		System.out.printf("This is student %d\n\n", studentnum);
		 		}
		 		break;
		 	case "3":
		 		System.out.println("====Student's data=====");
		 		for(i=0;i<num;i++)
		 		{
		 			System.out.printf("Number : %d\n",i+1);
		 			student[i].show_data();
		 			System.out.println();
		 			if(student[i].getScore()>=60)
		 				pass++;
		 			else
		 				nopass++;
		 		}
		 		System.out.println("===============");
		 		System.out.printf("Pass : %d\nNo pass : %d\n\n",pass,nopass);
		 		break;
		 		default:
		 			System.out.println("Error input!! Please input again.");
			 		break;
		 	}
		}
	}

}
