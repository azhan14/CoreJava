package com.neosoft.session;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeDeserialize {

	public static void main(String[] args) {
		List<Emp> emp = new ArrayList<Emp>();
		ObjectOutputStream oos = null;
		String file = "resources/emp.db";
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			emp.add(new Emp(1,"Vivek",30000,9));
			emp.add(new Emp(2,"Abhishek",35000,10));
			emp.add(new Emp(3,"kushal",27000,8));
			emp.add(new Emp(4,"Shruti",35000,10));
			emp.add(new Emp(5,"Nitya",32000,11));
			
			for(Emp e: emp) {
				oos.writeObject(e);
			}
			
			System.out.println("Serialization is done.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			while(true) {
				Emp emp1 = (Emp) ois.readObject();
				if(emp1.getDno() == 10) {
					System.out.println("Employee ID: "+emp1.getEid()+"\t");
					System.out.println("Employee Name: "+emp1.getEname()+"\t");
					System.out.println("Employee Salary: "+emp1.getEsal()+"\t");
					System.out.println("Employee DNo: "+emp1.getDno()+"\n");
				}
			}
		}
		catch(EOFException e) {
			System.out.println("End.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
