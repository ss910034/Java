package part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Course {

	private static Scanner input;

	public static void main(String[] args) {
		HashMap<Integer,ArrayList<String>> students =new HashMap<Integer,ArrayList<String>>();
		input = new Scanner(System.in);
		ArrayList<String> x;
		int id;
		String course;
		try {
			while(true){
				System.out.println("Please Input Data :");
				 
					 	id = input.nextInt();
						if( id == -1 ){
							System.out.println("List: "+students);
							break;
						}
						course = input.next();
						if(students.get(id)!=null){
							if(!students.get(id).contains(course)){
								students.get(id).add(course);
							}
						}
						else{
							x = new ArrayList<String>();
							x.add(course);
							students.put(id,x);
						}
			        
			}
		}
		catch (InputMismatchException ex) {
		            System.out.println("ID must be Integer.");
		        }
		
	}

}
