package nagyhf;

import java.io.Serializable;

/**
 * 
 * @author szombat
 *Bármilyen tárolandó osztálynak a következő metódusokat meg kell valósítania:
 *getZero,getOne,getTwo,... amennyi elem van. a CustomTable.java-ban
 *pedig a getValue fg-t ezek alapján kell kibővíteni.
 */
public class Car implements Serializable{
	private int id;
	public String name;
	public String color;
	public int power;
	
	public Car(int i,String n,String c,int p){
		id = i;
		name = n;
		color = c;
		power = p;
	}
	
	public Car(){
		id = 9999;
		name = "undefined_name";
		color = "undefined_color";
		power = 9999;
	}
	
	public int getZero(){
		return id;
	}
	
	public String getOne(){
		return name;
	}
	
	public String getTwo(){
		return color;
	}
	
	public int getThree(){
		return power;
	}
	public void setZero(int i){
		id =  i;
	}
	
	public void setOne(String n){
		name =   n;
	}
	
	public void setTwo(String c){
		color =   c;
	}
	
	public void setThree(int p){
		power =   p;
	}
}
