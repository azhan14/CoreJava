package com.neosoft.session;

import java.util.Scanner;

public class Student {

		int stdid;
		String name;
		String course;
		int marks;

		public Student(int stdid, String name, String course, int marks) {
			this.stdid = stdid;
			this.name = name;
			this.course = course;
			this.marks = marks;
		}
		
		public void showData() {
			System.out.println("Student ID: "+stdid);
			System.out.println("Student Name: "+name);
			System.out.println("Subject: "+course);
			System.out.println("Marks: "+marks);
			System.out.println("=================");
		}


		public static void main(String[] args) {
//			Student student1 = new Student(1,"Azhan","BCA",90);
//			Student student2 = new Student(2,"Pratham","WDL",80);
//			Student student3 = new Student(3,"Amaan","BCA",85);
//			Student student4 = new Student(4,"Makrand","ERP",75);
//			Student student5 = new Student(5,"Harsh","ML",70);
			Scanner sc = new Scanner(System.in);
			Student[] student = new Student[5];
			for(int i = 0; i < 5 ;i++) {
				System.out.println("Enter details of student "+(i+1)+" :");
				System.out.println("Enter Student ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Student Name: ");
				String name = sc.nextLine();
				System.out.println("Enter Student Course: ");
				String course = sc.nextLine();
				System.out.println("Enter marks: ");
				int marks = sc.nextInt();
				student[i] = new Student(id,name,course,marks);
			}
			
			
			for(Student s: student) {
				if((s.marks > 60) && (s.course.equals("BCA"))) {
					s.showData();
				}
			}
			sc.close();
		}
}
