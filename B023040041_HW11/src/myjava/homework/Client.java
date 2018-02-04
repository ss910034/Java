package myjava.homework;

import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONObject;

public class Client
{
    public static void main( String[] args ) throws IOException
    {
        String host = "";
        int port = 0,money = 0;
        Socket socket = null;
        Scanner in = new Scanner( System.in );
        System.out.println("Please input your ip address : ");
        host = in.nextLine();
        System.out.println("Please input your port : ");
        port = in.nextInt();
        System.out.println("Connection....");
        try
        {
        	DataInputStream input = null;
            DataOutputStream output = null;
            socket = new Socket( host, port );        
            String user = null ;
            try
            {
            	HashMap<String,User> x = new HashMap<String,User>();
                input = new DataInputStream( socket.getInputStream() );
                output = new DataOutputStream( socket.getOutputStream() );
                System.out.println("Connected successfully!!");
                String strInputstream ="";                            
                ByteArrayOutputStream baos = new ByteArrayOutputStream();  
                byte[] by = new byte[2048];  
                int n;  
                while((n=input.read(by))!=-1){  
                    baos.write(by,0,n);           
                }  
                strInputstream = new String(baos.toByteArray());   
                baos.close();  
                JSONObject json = new JSONObject(strInputstream);
                Iterator<String> nameItr = json.keys();
                HashMap<String,User> outMap = new HashMap<String,User>();
                String m;
                while(nameItr.hasNext()) {
                    String name = nameItr.next();
                    User cu = new User(name);
                    m = json.get(name).toString();
                    String[] AfterSplit = m.substring(1, m.length()-1).split("[\",]");
                    for (int i = 0; i < AfterSplit.length; i++)
                    {
                    	if(AfterSplit[i].length()!=0){
                    		cu.friends.add(new User(AfterSplit[i]));
                    	}
                    }
                    outMap.put(name,cu);
                }
                while(true){
                	System.out.println("Username : \tFriends");
                	System.out.println("-----------------------------------");
                	 for (Object key : outMap.keySet()) {
                		 Iterator iterator = outMap.get(key).friends.iterator();
                		 System.out.print(key + " : {");
                	        while(iterator.hasNext()){
                	        	System.out.print("\""+((User) iterator.next()).getname()+"\"");
                	        	if(iterator.hasNext())
                	        		System.out.print(",");
                	        }               	          
                         System.out.println("}");
                         System.out.println("-----------------------------------");
                     }
                	System.out.println("Enter a name : ");
                	user = in.next();
                	if(outMap.get(user)!=null){
                		System.out.println("Unidirectional : ");
                		Iterator iterator1 = outMap.get(user).friends.iterator();
                	    while(iterator1.hasNext())
                	    	System.out.println(user+" -----> "+((User) iterator1.next()).getname());
                	    iterator1 = outMap.get(user).friends.iterator();
                	    System.out.println("-----------------------------------");
                    	System.out.println("Bidirectional : ");
                    	while(iterator1.hasNext()){
                    		String name = ((User) iterator1.next()).getname();
                    		Iterator iterator2 = outMap.get(name).friends.iterator();
                    	    while(iterator2.hasNext()){
                    	    	if(user.equals(((User) iterator2.next()).getname())){
                    	    		System.out.println(user+" <-----> "+name);
                    	    		break;
                    	    	}	
                    	    }
                	    		
                    	}  
                    	System.out.println("-----------------------------------\n");
                	}
                	else
                		System.out.println(user+" doesn't have friends.\n");
                	
                }	              
            }
            catch ( IOException e )
            {
            }
            finally 
            {
                if ( input != null )
                    input.close();
                if ( output != null )
                    output.close();
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        finally
        {
            if ( socket != null )
                socket.close();
            if ( in != null )
                in.close();
        }
    }
}