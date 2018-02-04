package myjava.homework;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONArray;
import org.json.JSONObject;

public class Server
{
    public static final int LISTEN_PORT = 12345;
    
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
        Server server1 = new Server();
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
                User person  = new User("spoiled_brat");
                User person2  = new User("loser");
                User person3 = new User("brat");
                User person4  = new User("loner");
                User person5  = new User("hater");
                person.friends.add(person2);
                person.friends.add(person3);
                person.friends.add(person5);
                person2.friends.add(person);
                person2.friends.add(person3);
                person3.friends.add(person2);
                person3.friends.add(person);
                person3.friends.add(person5);
                person4.friends.add(person2);
                person5.friends.add(person);
                person5.friends.add(person5);
                HashMap<String,User> people = new HashMap<String,User>();
                ArrayList<String> people1 = new ArrayList<String>();
                JSONObject json = new JSONObject();
                people1.add("loser");
                people1.add("brat");
                people1.add("hater");
                json.put("spoiled_brat",people1);
                people1.clear();
                people1.add("spoiled_brat");
                people1.add("brat");
                json.put("loser",people1);
                people1.clear();
                people1.add("spoiled_brat");
                people1.add("loser");
                people1.add("hater");
                json.put("brat",people1);
                people1.clear();
                people1.add("loser");
                json.put("loner",people1);
                people1.clear();
                people1.add("spoiled_brat");
                people1.add("brat");
                json.put("hater",people1);
                people1.clear();
                //while(true){
                	String jsonString = "";  
                	jsonString = json.toString();  
                	byte[] jsonByte = jsonString.getBytes();  
					output = new DataOutputStream(clientSocket.getOutputStream());  
                    output.write(jsonByte);  
                    output.flush();  
               // }
                    
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