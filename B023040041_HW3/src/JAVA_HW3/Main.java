package JAVA_HW3;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main
{

    public static void main(String[] args)
    {
        Student_list list = new Student_list();
        String name;
        int id;
        int out=0;
        while(true)
        {
            try
            {
                Scanner input = new Scanner(System.in);
                System.out.println("<1> Add one student to the list.");
                System.out.println("<2> Remove one student from the list.");
                System.out.println("<3> Display the student list.");
                System.out.println("<4> Exit");
                System.out.print("Input : ");
                int choose = input.nextInt();
                switch(choose)
                {
                case 1:
                    System.out.print("Student's name: ");
                    name=input.next();
                    System.out.print("Student's ID: ");
                    id=input.nextInt();
                    Student_info newmember = new Student_info(name,id);
                    list.add(newmember);
                    break;
                case 2:
                    System.out.println("Remove from <1>name <2>id :");
                    int choose2=input.nextInt();
                    switch(choose2)
                    {
                    case 1:
                        System.out.print("Student's name : ");
                        name=input.next();
                        if(list.remove(name)==1)
                        	System.out.println();
                        break;
                    case 2:
                        System.out.print("Student's id : ");
                        id=input.nextInt();
                        if(list.remove(id)==1)
                            System.out.println();
                    }
                    break;
            case 3:
                list.display();
                break;
            case 4:
            	System.out.println("Bye ~");
            	out=1;
                break;
                default:
                	System.out.println("[Error] Out of range\n[Error] Try Again");
                	break;
            } 
            if(out==1)
            	break;
        }   
        catch (InputMismatchException ex)
        {
            System.out.println("[Error] Wrong Input!\n[Error] Try Again!\n");
        }
    }
}
}
