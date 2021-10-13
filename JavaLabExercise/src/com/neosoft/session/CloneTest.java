package com.neosoft.session;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Pulsar pulsar1 = new Pulsar(125,800);
		Pulsar pulsar1_1 = (Pulsar) pulsar1.clone();
		Pulsar pulsar1_2 = (Pulsar) pulsar1.clone();
		Pulsar pulsar1_3 = (Pulsar) pulsar1.clone();
		Pulsar pulsar1_4 = (Pulsar) pulsar1.clone();
		Pulsar pulsar1_5 = (Pulsar) pulsar1.clone();
		
		List<Pulsar> pulsar = new ArrayList<Pulsar>();
		ObjectOutputStream oos = null;
		String file = "resources/pulsar.db";
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			pulsar.add(pulsar1_1);
			pulsar.add(pulsar1_2);
			pulsar.add(pulsar1_3);
			pulsar.add(pulsar1_4);
			pulsar.add(pulsar1_5);
			for(Pulsar p: pulsar) {
				oos.writeObject(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		ObjectInputStream ois = null;
		int count = 1;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			while(true) {
				
				Pulsar p1 = (Pulsar) ois.readObject();
				System.out.println("Pulsar Clone "+count);;
				System.out.println("Pulsar CC: "+p1.getCC());
				System.out.println("Pulsar Series: "+p1.getSeries());
				count++;
			}
		}
		catch(EOFException e) {
			System.out.println("End.");
		}
		catch (Exception e) {
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

class Pulsar implements Cloneable,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int CC;
	int series;
	
	public int getCC() {
		return CC;
	}

	public void setCC(int cC) {
		CC = cC;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Pulsar(int CC, int series) {
		this.CC = CC;
		this.series = series;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}