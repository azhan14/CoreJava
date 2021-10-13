package com.neosoft.session;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.portable.ValueBase;

public class MapInterfaceTest {

	public static void main(String[] args) {
		Employees empObj1 = new Employees(1, "Elon", 20000);
		Employees empObj2 = new Employees(2, "Amaan", 19000);
		Employees empObj3 = new Employees(3, "Pratham", 18000);
		Employees empObj4 = new Employees(4, "Sreejith", 17000);
		Employees empObj5 = new Employees(5, "Arif", 11000);
		Employees empObj6 = new Employees(6, "Shivam", 15000);
		Employees empObj7 = new Employees(7, "Sahil", 14000);
		Employees empObj8 = new Employees(8, "Saloni", 13000);
		Employees empObj9 = new Employees(9, "Bill", 21000);
		Employees empObj10 = new Employees(10, "Jeff", 22000);
		
		Map<Integer,Employees> map = new HashMap<Integer, Employees>();
		map.put(1, empObj1);
		map.put(2, empObj2);
		map.put(3, empObj3);
		map.put(4, empObj4);
		map.put(5, empObj5);
		map.put(6, empObj6);
		map.put(7, empObj7);
		map.put(8, empObj8);
		map.put(9, empObj9);
		map.put(10, empObj10);
		System.out.println("Sorted Employee List: ");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		System.out.println("========================================================================");
//		System.out.println("After Removing employees with salary less than 15000:");
		map.entrySet().removeIf(entry -> entry.getValue().esal < 15000);
//		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		System.out.println("========================================================================");
		System.out.println("New HashMap with employees having salary greater than 15000");
		Map<Integer,Employees> newMap = new HashMap<Integer, Employees>(map);
		newMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
	}

}

class Employees{
	int eid;
	String ename;
	double esal;
	public Employees(int eid, String ename, double esal) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	@Override
	public String toString() {
		return " Empployee ID: "+eid+" Employee Name: "+ename+" Employee Salary: "+esal;
	}
}