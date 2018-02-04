package myjava.homework;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server
{
    public static final int LISTEN_PORT = 12345;
    static ArrayList<information> sr = new ArrayList<information>();
    public void listenRequest()
    {
        ServerSocket serverSocket = null;
        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        try
        {
            serverSocket = new ServerSocket( LISTEN_PORT );
            System.out.println("Server listening requests...");
            while ( true )
            {
                Socket socket = serverSocket.accept();
                threadExecutor.execute( new RequestThread( socket ) );
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        finally
        {
            if ( threadExecutor != null )
                threadExecutor.shutdown();
            if ( serverSocket != null )
                try
                {
                    serverSocket.close();
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
        }
    }
    public static void main( String[] args )
    {
    	
		information x = new information("a",1,50);
		sr.add(x);
        server server1 = new server();
        server1.listenRequest();
    }

    class RequestThread implements Runnable
    {
        private Socket clientSocket;
        
        public RequestThread( Socket clientSocket )
        {
            this.clientSocket = clientSocket;
        }

        public void run()
        {
        	DataInputStream input = null;
            DataOutputStream output = null;  
            try
            {
                input = new DataInputStream( this.clientSocket.getInputStream() );
                output = new DataOutputStream( this.clientSocket.getOutputStream() );
                while(true){
	                int chosen = input.readInt();
	                String account = null;
	                int pass = 0, pass1 = 0 ,money =0, i = 0 , error = 0,out = 0;
	                switch(chosen){
	                case 1:
	                	account = input.readUTF();
	                	for(i=0;i<sr.size();i++){
	                		if(sr.get(i).getAccount().equals(account)){
	                			error = 1;
	                			break;
	                		}
	                	}
	                	output.writeInt(error);
	                	if( error == 0){
	                		pass = input.readInt();
	                		information x = new information(account,pass,0);
	                		sr.add(x);
	                	}
	                	break;
	                case 2:
	                	account = input.readUTF();
	                	for(i=0;i<sr.size();i++){
	                		if(sr.get(i).getAccount().equals(account)){
	                			pass1 = sr.get(i).getPassword();
	                			break;
	                		}
	                	}
	                	pass = input.readInt();
	                	if( pass == pass1 )
	                		error = 0;
	                	else
	                		error = 1;
	                	output.writeInt(error);
	                	if( error == 0 ){
	                		money = input.readInt();
	                		for(i=0;i<sr.size();i++){
	                    		if(sr.get(i).getAccount().equals(account)){
	                    			money += sr.get(i).getMoney();
	                    			sr.remove(i);
	                    			information y = new information(account,pass,money);
	                    			sr.add(y);
	                    			output.writeInt(money);
	                    			break;
	                    		}
	                    	}
	                	}
	                	break;
	                case 3:
	                	out=1;
	                	break;
	                }
	                if( out == 1 )
	                	break;
                }
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
            finally 
            {
                try
                {
                    if ( input != null )
                        input.close();
                    if ( output != null )
                        output.close();
                    if ( this.clientSocket != null && !this.clientSocket.isClosed() )
                        this.clientSocket.close();
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }
        }
    }
}