package myjava.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.mysql.jdbc.ResultSetMetaData;

public class HW10_Main {

	public static void main(String[] args) {
		String account = null , pass = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Animal c,d;
		Set<Animal> petset1 = new HashSet<Animal>();
		Set<Animal> petset2 = new HashSet<Animal>();
		String url ="jdbc:mysql://localhost:3306/java_db?autoReconnect=true&useSSL=false";
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter useraccount : ");
		account = input.nextLine();
		System.out.println("Please enter password : ");
		pass = input.nextLine();
		try {
			Connection conDB = DriverManager.getConnection(url, account, pass);
			System.out.println("Connection establish.\n");
			System.out.println("----------------------[Cat]----------------------");
			Statement stmt = conDB.createStatement();
			String sql = "SELECT * FROM cat";
			stmt.executeQuery(sql);
			ResultSet rs = stmt.getResultSet();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			while( rs.next() ){
				c = new Animal(rs.getString("id"),rs.getString("sex"),rs.getObject("weight"),rs.getObject("bloodpressure"));
				petset1.add(c);
			}
			Iterator<Animal> iterator=petset1.iterator();
			ArrayList<Integer> intdata = new ArrayList<>();
			ArrayList<Double> doudata = new ArrayList<>();
			HealthCheck<Integer> he = new HealthCheck<Integer>();
			HealthCheck<Double> hed = new HealthCheck<Double>();
			System.out.print("CatList : [");
	        while (iterator.hasNext()){
	            System.out.print(iterator.next().toString());
	            if(iterator.hasNext())
	            	System.out.print(", ");
	        }
	        System.out.println("]");
	        iterator=petset1.iterator();
	        Animal x = null;
	        while (iterator.hasNext()){
	        	x=iterator.next();
	        	if(rsmd.getColumnTypeName(3).equals("INT"))
	        		intdata.add((Integer) x.getWeight());
	        	else
	        		doudata.add((Double) x.getWeight());	        	
	        }
	        if(rsmd.getColumnTypeName(3).equals("INT"))
	        {
		        System.out.println("MaxWeight : "+he.MaxWeight(intdata));
		        System.out.println("MinWeight : "+he.MinWeight(intdata));
		        System.out.println("AverageWeight : "+he.AverageWeight(intdata));
	        }else
	        {
	        	System.out.println("MaxWeight : "+hed.MaxWeight(doudata));
		        System.out.println("MinWeight : "+hed.MinWeight(doudata));
		        System.out.println("AverageWeight : "+hed.AverageWeight(doudata));
	        }
	        intdata = new ArrayList<>();
			doudata = new ArrayList<>();
	        iterator=petset1.iterator();
	        while (iterator.hasNext()){
	        	x=iterator.next();
	        	if(rsmd.getColumnTypeName(4).equals("INT"))
	        		intdata.add((Integer) x.getbloodpressure());
	        	else
	        		doudata.add((Double) x.getbloodpressure());
	        } 
	        if(rsmd.getColumnTypeName(4).equals("INT"))
	        {
		        System.out.println("MaxWeight : "+he.MaxBloodPressure(intdata));
		        System.out.println("MinWeight : "+he.MinBloodPressure(intdata));
		        System.out.println("AverageWeight : "+he.AverageBloodPressure(intdata));
	        }else
	        {
	        	System.out.println("MaxWeight : "+hed.MaxBloodPressure(doudata));
		        System.out.println("MinWeight : "+hed.MinBloodPressure(doudata));
		        System.out.println("AverageWeight : "+hed.AverageBloodPressure(doudata));
	        }
	        
	        System.out.println("-------------------------------------------------\n");
	        System.out.println("----------------------[Dog]----------------------");
			stmt = conDB.createStatement();
			sql = "SELECT * FROM dog";
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
			rsmd = (ResultSetMetaData) rs.getMetaData();
			while( rs.next() ){
				d = new Animal(rs.getString("id"),rs.getString("sex"),rs.getObject("weight"),rs.getObject("bloodpressure"));
				petset2.add(d);
			}
			iterator=petset2.iterator();
			intdata = new ArrayList<>();
			doudata = new ArrayList<>();
			he = new HealthCheck<Integer>();
			hed = new HealthCheck<Double>();
			System.out.print("DogList : [");
	        while (iterator.hasNext()){
	            System.out.print(iterator.next().toString());
	            if(iterator.hasNext())
	            	System.out.print(", ");
	        }
	        System.out.println("]");
	        iterator=petset2.iterator();
	        x = null;
	        System.out.println(rsmd.getColumnTypeName(4));
	        while (iterator.hasNext()){
	        	x=iterator.next();
	        	if(rsmd.getColumnTypeName(3).equals("INT"))
	        		intdata.add((Integer) x.getWeight());
	        	else
	        		doudata.add((Double) x.getWeight());	        	
	        }
	        if(rsmd.getColumnTypeName(3).equals("INT"))
	        {
		        System.out.println("MaxWeight : "+he.MaxWeight(intdata));
		        System.out.println("MinWeight : "+he.MinWeight(intdata));
		        System.out.println("AverageWeight : "+he.AverageWeight(intdata));
	        }else
	        {
	        	System.out.println("MaxWeight : "+hed.MaxWeight(doudata));
		        System.out.println("MinWeight : "+hed.MinWeight(doudata));
		        System.out.println("AverageWeight : "+hed.AverageWeight(doudata));
	        }
	        intdata = new ArrayList<>();
			doudata = new ArrayList<>();
	        iterator=petset2.iterator();
	        while (iterator.hasNext()){
	        	x=iterator.next();
	        	if(rsmd.getColumnTypeName(4).equals("INT"))
	        		intdata.add((Integer) x.getbloodpressure());
	        	else
	        		doudata.add((Double) x.getbloodpressure());
	        } 
	        if(rsmd.getColumnTypeName(4).equals("INT"))
	        {
		        System.out.println("MaxWeight : "+he.MaxBloodPressure(intdata));
		        System.out.println("MinWeight : "+he.MinBloodPressure(intdata));
		        System.out.println("AverageWeight : "+he.AverageBloodPressure(intdata));
	        }else
	        {
	        	System.out.println("MaxWeight : "+hed.MaxBloodPressure(doudata));
		        System.out.println("MinWeight : "+hed.MinBloodPressure(doudata));
		        System.out.println("AverageWeight : "+hed.AverageBloodPressure(doudata));
	        }
	        System.out.println("-------------------------------------------------\n");
		} catch (SQLException e) {
			System.out.println("Error! Account or password was wrong!");
			//e.printStackTrace();
		}

	}
}
