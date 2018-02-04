package myjava.homework;

import java.util.Objects;

public class Animal<T,K> {
	public String id;
	public String sex;
	public K bloodpressure;
	public T weight;
	public Animal(String x,String y,T w,K b){
		id = x;
		sex = y;
		bloodpressure = b;
		weight = w;
	}
	public K getbloodpressure(){
		return this.bloodpressure;
	}
	public T getWeight(){
		return this.weight;
	}
	public int hashCode(){
		int hash = 7 ;
	    hash = 47 * hash + this.id.hashCode();
	    hash = 37 * hash + this.sex.hashCode();
	    hash = 27 * hash + this.bloodpressure.hashCode();
	    hash = 17 * hash + this.weight.hashCode();
	    return hash;
	}
	public String toString(){
		return String.format("(%s, %s, %s, %s)", this.id, this.sex,this.bloodpressure,this.weight);
	}
	public boolean equals(Object x){
		if (x == null) {
            return false;
        }
		if(getClass() != x.getClass())
			return false;
		if(hashCode() != x.hashCode())
			return false;
		final Animal other = (Animal) x;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        if (!Objects.equals(this.bloodpressure, other.bloodpressure)) {
        	return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        return true;
	}
}
