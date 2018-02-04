package myjava.homework;

import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client
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
            String account = null ;
            try
            {
                input = new DataInputStream( socket.getInputStream() );
                output = new DataOutputStream( socket.getOutputStream() );
                System.out.println("Connected successfully!!");
                while(true){
                	int choose = 0,error = 0,pass = 0, check = 0,out =0;
                	
                	System.out.println("(1).add new account\n(2).Sign in\n(3).leave");
	                choose = in.nextInt();
	                output.writeInt(choose);
	                switch(choose){
		                case 1:
		                account = in.nextLine();
		            	System.out.println("input your account : ");
		            	account = in.nextLine();
		            	output.writeUTF(account);
		            	error = input.readInt();
		            	if( error == 0 ){
		            		System.out.println("input your password : ");
			            	pass = in.nextInt();
			            	output.writeInt(pass);
		            	}
		            	else
		            		System.out.println("Error , have the same account.");
		            	break;
		                case 2:
		                	account = in.nextLine();
			            	System.out.println("input your account : ");
			            	account = in.nextLine();
			            	output.writeUTF(account);
			            	System.out.println("input your password : ");
				            pass = in.nextInt();
				            output.writeInt(pass);
			            	error = input.readInt();
			            	if( error == 0 ){
			            		System.out.println("input your money : ");
			            		money = in.nextInt();
			            		output.writeInt(money);
			            		check = input.readInt();
			            		System.out.println(check);
			            	}
			            	else
			            		System.out.println("Can't find the account.");
		                	break;
		                case 3:
		                	System.out.println("Bye ~");
		                	out = 1;
		                	break;
		            }
	                output.writeInt(out);
	                if( out == 1 ){
	                	break;
	                }
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