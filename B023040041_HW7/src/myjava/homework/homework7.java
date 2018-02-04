package myjava.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import java.util.HashMap;

public class homework7 {
      
    public static void main(String[] args) {  
        HashMap<String, String> store1 = new HashMap<String , String> (8000);
        HashMap<String, String> store2 = new HashMap<String , String> (8000);
        File file = new File("query_result.csv");
        int a = 0, b = 0, c =0, male = 0, female = 0;
        
    	try{
    		CSVReader reader = new CSVReader(new FileReader(file));
    		String[] nextLine;
    		try {
				while((nextLine = reader.readNext()) != null){
					store1.put(nextLine[0] + nextLine[1], nextLine[1]);
					store2.put(nextLine[0] + nextLine[2], nextLine[2]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
    		for (String key : store1.keySet()){
    			if(store1.get(key).equals("Product_A")){
    				a++;
    			}
    			else if(store1.get(key).equals("Product_B")){
    				b++;
    			}
    			else if(store1.get(key).equals("Product_C")){
    				c++;
    			}
    		}
    		for (String key : store2.keySet()){
    			if(store2.get(key).equals("F")){
    				female++;
    			}
    			else if(store2.get(key).equals("M")){
    				male++;
    			}
    			
    		}
    	} 
        catch(FileNotFoundException e){
        	e.printStackTrace();
        }
    	new PieChart(a,b,c,female,male);
    	
    }  
}  
