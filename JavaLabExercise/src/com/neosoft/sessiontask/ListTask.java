package com.neosoft.sessiontask;

import java.util.ArrayList;
import java.util.List;

public class ListTask {

	public static void main(String[] args) {
		Trainer T1 = new Trainer(1,"Vivek","C",29000);
		Trainer T2 = new Trainer(2, "Pratham", "Java", 30000);
		Trainer T3 = new Trainer(3, "Vishal", "JS", 20000);
		Trainer T4 = new Trainer(4, "Prashik", "Java", 25000);
		Trainer T5 = new Trainer(5, "Mohsin", "HTML", 15000);
		
		List<Trainer> trainer = new ArrayList<Trainer>();
		trainer.add(T1);
		trainer.add(T2);
		trainer.add(T3);
		trainer.add(T4);
		trainer.add(T5);
		
		List<Trainer> filterTrainer = new ArrayList<Trainer>();
		
		System.out.println("Trainer before Filtering: ");
		for(Trainer t: trainer) {
			t.showTrainer();
		}
		for(int i = 0; i < trainer.size(); i++) {
			Trainer t = trainer.get(i);
			if((t.salary > 20000) && (t.course.equals("Java"))){
				filterTrainer.add(t);
				trainer.remove(t);
			}
		}
		
		System.out.println("Trainer After Filtering: ");
		System.out.println("==========================");
		for(Trainer t: filterTrainer) {
			t.showTrainer();
		}
	}

}

class Trainer{
	int tr_id;
	String name;
	String course;
	double salary;
	public Trainer(int tr_id, String name, String course, double salary) {
		this.tr_id = tr_id;
		this.name = name;
		this.course = course;
		this.salary = salary;
	}
	
	void showTrainer() {
		System.out.println("Trainer ID: "+tr_id);
		System.out.println("Trainer Name: "+name);
		System.out.println("Trainer Course: "+course);
		System.out.println("Trainer Salary: "+salary);
		System.out.println("============================");
	}
}