package com.neosoft.sessiontask;

import java.util.Scanner;
public class EnumStudent {
	int stdid;
	String name;
	Subject subject;
	int marks;

	public EnumStudent(int stdid, String name, Subject subject, int marks) {
		this.stdid = stdid;
		this.name = name;
		this.subject = subject;
		this.marks = marks;
	}



	public static void main(String[] args) {
		EnumStudent student1 = new EnumStudent(1,"Azhan",Subject.PYTHON,90);
		EnumStudent student2 = new EnumStudent(2,"Pratham",Subject.C,80);
		EnumStudent student3 = new EnumStudent(3,"Amaan",Subject.JAVA,85);
		EnumStudent student4 = new EnumStudent(4,"Makrand",Subject.PYTHON,75);
		EnumStudent student5 = new EnumStudent(5,"Harsh",Subject.CPP,70);
		
		EnumStudent[] student = {student1,student2,student3,student4,student5};
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a subject name: ");
		String subject = sc.nextLine();
		
		for(EnumStudent i: student) {
			if(i.subject == Subject.valueOf(subject)) {
				System.out.println("Student ID: "+i.stdid);
				System.out.println("Student Name: "+i.name);
				System.out.println("Subject: "+i.subject);
				System.out.println("Marks: "+i.marks);
			}
		}
		
		sc.close();
	}

}
