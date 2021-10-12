package com.neosoft.session;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentRegex {

	public static void main(String[] args) {
		StudentR[] student = new StudentR[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter details of 5 students: ");
		for(int i = 0; i < 5; i++) {
			System.out.println("Enter Student ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Student Name: ");
			String name = sc.nextLine();
			System.out.println("Enter mobile number: ");
			int flag = 0;
			String mobile="";
			while(flag != 1) {
				mobile = sc.nextLine();
				if(Pattern.matches("[0-9]{10}", mobile)) {
					flag = 1;
				}
				else {
					System.out.println("Please Enter 10 digit mobile number: ");
				}
			}
			flag = 0;
			String email="";
			System.out.println("Enter Student Email: ");
			while(flag != 1) {
				email = sc.nextLine();
				if(Pattern.matches("[A-Za-z0-9_]{1,}[@][a-z]{1,}[.][a-z]{1,}", email)) {
					flag = 1;
				}
				else {
					System.out.println("Please Enter valid Email: ");
				}
			}
			
			student[i] = new StudentR(id,name,mobile,email);
		}
		System.out.println("==============================================");
		System.out.println("Students with mobile number starting with 98: ");
		for(int i = 0; i < 5; i++) {
			String sub = student[i].mobile.substring(0, 2);
			if(sub.equals("98")) {
				student[i].display();
			}
		}
		
		System.out.println("==============================================");
		System.out.println("Students whose Email ID is from gmail: ");
		int count = 0;
		for(int i = 0; i < 5; i++) {
			String sub = student[i].email.substring(student[i].email.indexOf('@')+1);
			if(sub.equals("gmail.com")) {
				student[i].display();
			}
			else {
				count++;
			}
		}
		System.out.println("Count of students whose Email ID is not from gmail: "+count);
		
	}

}

class StudentR{
	int stid;
	String stname, mobile, email;
	public StudentR(int stid, String stname, String mobile, String email) {
		this.stid = stid;
		this.stname = stname;
		this.mobile = mobile;
		this.email = email;
	}
	void display() {
		System.out.println("Student ID: "+stid);
		System.out.println("Student name: "+stname);
		System.out.println("Student Mobile: "+mobile);
		System.out.println("Student Email: "+email);
		System.out.println("=======================");
	}
}