package homework.part2;

import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		ItemList item = new ItemList();
		Scanner input =new Scanner(System.in);
		String newname,choose="";
		while(true)
		{
			System.out.println("type 1 : add item to list");
			System.out.println("type 2 : remove item from list");
			System.out.println("type 3 : show the list");
			if(input.hasNext())
				choose = input.next();
			else
			{
				System.out.println("Bye~");
				break;
			}
		 	switch(choose)
		 	{
		 	case "1":
		 		System.out.print("Add item name : ");
		 		newname=input.next();
		 		item.addItem(newname);
		 		System.out.println();
		 		break;
		 	case "2":
		 		System.out.print("remove item name : ");
		 		String remname=input.next();
		 		item.remove(remname);
		 		System.out.println();
		 		break;
		 	case "3":
		 		System.out.println("show the list");
		 		item.printList();
		 		System.out.println();
		 		break;
		 	default :
		 		System.out.println("Error input!! Please input again.");
		 		break;
		 	}
		}
	}

}
