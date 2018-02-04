package myjava.homework;

import java.util.Scanner;
import java.sql.*;

public class SQLProject {

	private static Scanner input;

	public static void main(String[] args) throws ClassNotFoundException {
		String account = null , pass = null,id = null;
		int max = 0,min = 999999,cmax=0 ,countf = 0,countm = 0;
		float chinese = 0,count=0,eng = 0 ;
		float avg = 0;
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/java_db?autoReconnect=true&useSSL=false";
		input = new Scanner(System.in);
		System.out.println("Please enter useraccount : ");
		account = input.nextLine();
		System.out.println("Please enter password : ");
		pass = input.nextLine();
		
		try {
			Connection conDB = DriverManager.getConnection(url, account, pass);
			System.out.println("Connection establish.");
			Statement stmt = conDB.createStatement();
			String sql = "SELECT * FROM grades";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.getResultSet();
			while( rs.next() ){
			   chinese += rs.getInt("chinese");
			   if( rs.getInt("math") > max )
				   max = rs.getInt("math");
			   if( min > rs.getInt("chinese") )
				   min = rs.getInt("chinese");
			   if( rs.getInt("chinese") > cmax ){
				   cmax = rs.getInt("chinese");
				   id = rs.getString("id");
			   }
			   count++;
			}
			avg = chinese / count;
			System.out.println("\nQuery 1:\nc_avg\t\tm_max\t\tc_min");
			System.out.println(avg+"\t\t"+max+"\t\t"+min+"\n");
			System.out.println("Query 2:\nid\t\tchinese");
			System.out.println(id+"\t\t"+cmax+"\n");
			
			stmt = conDB.createStatement();
			sql = "SELECT * FROM students WHERE id LIKE 'A%' ORDER BY sex";
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
			System.out.println("Query 3:\nid\t\tsex\t\tbirthmonth");
			while( rs.next() ){
				System.out.println(rs.getString("id")+"\t\t"+rs.getString("sex")+"\t\t"+rs.getInt("birthmonth"));
			}
			
			count=0;
			System.out.println("\nQuery 4:\ne_avg");
			sql = "SELECT * FROM students WHERE sex = 'F'";
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
			while( rs.next() ){
				id = rs.getString("id");
				Statement stmt1 = conDB.createStatement();
				String sql1 = "SELECT * FROM grades WHERE id = '"+id+"'";
				stmt1.executeQuery(sql1);
				ResultSet rs1 = stmt1.getResultSet();
				while( rs1.next() ){
					eng += rs1.getInt("english");
					count++;
				}
			}
			System.out.println(eng/count);
			
			stmt = conDB.createStatement();
			sql = "SELECT * FROM students WHERE birthmonth BETWEEN 6 and 10 ORDER BY sex ";
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
			System.out.println("\nQuery 5:\nsex\t\tcount");
			while( rs.next() ){
				if( rs.getString("sex").equals("F") )
					countf++;
				else
					countm++;
			}
			System.out.println("F\t\t"+countf);
			System.out.println("M\t\t"+countm);
		} catch (SQLException e) {
			System.out.println("Error! Account or password was wrong!");
			//e.printStackTrace();
		}

	}

}
