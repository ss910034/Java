package myjava.homework;

import java.util.ArrayList;

public class HealthCheck<T extends Comparable<T>>  {
	public double AverageBloodPressure(ArrayList<T> z){
		double x = 0;
		for(int i=0;i<z.size();i++){
			x +=Double.parseDouble(z.get(i).toString());
		}
		return (double) x/z.size();
	}
	public double AverageWeight(ArrayList<T> z){
		double x = 0;
		for(int i=0;i<z.size();i++){
			x +=Double.parseDouble(z.get(i).toString());
		}
		return (double) x/z.size();
	}
	public T MaxBloodPressure(ArrayList<T> z){
		T x = z.get(0);
		for(int i=1;i<z.size();i++){
			if(x.compareTo(z.get(i))<0)
				x = z.get(i);
		}
		return x;
	}
	public T MaxWeight(ArrayList<T> z){
		T x = z.get(0);
		for(int i=1;i<z.size();i++){
			if(x.compareTo(z.get(i))<0)
				x = z.get(i);
		}
		return x;
	}
	public T MinBloodPressure(ArrayList<T> z){
		T x = z.get(0);
		for(int i=1;i<z.size();i++){
			if(x.compareTo(z.get(i))>0)
				x = z.get(i);
		}
		return x;
	}
	public T MinWeight(ArrayList<T> z){
		T x = z.get(0);
		for(int i=1;i<z.size();i++){
			if(x.compareTo(z.get(i))>0)
				x = z.get(i);
		}
		return x;
	}
	
}
