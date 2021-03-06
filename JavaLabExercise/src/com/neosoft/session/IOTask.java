package com.neosoft.session;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IOTask {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email List File Name: ");
		String fileName = sc.nextLine();
		File email = new File("resources/"+fileName);
		BufferedWriter br1 = new BufferedWriter(new FileWriter(email,true));
		
		String emailId;
		System.out.println("Enter 5 valid emails: ");
		for(int i =0;i<5;i++) {
			emailId = sc.nextLine();
			if(Pattern.matches("\\w{1,}[@][a-z]{1,}[.][a-z]{1,}",emailId)) {
				br1.write(emailId);
				br1.newLine();
			}
			else {
				System.out.println("Please enter valid email Id:");
				i--;
			}
		}
		br1.close();
		System.out.println("Enter Domain List File Name: ");
		String domainFileName = sc.nextLine();
		File domain = new File("resources/"+domainFileName);
		BufferedReader br2 = new BufferedReader(new FileReader(email));
		BufferedWriter br3 = new BufferedWriter(new FileWriter(domain,true));
		String line;
		String domain1;
		while((line = br2.readLine()) != null) {
			domain1 = line.substring(line.lastIndexOf('@')+1);
			br3.write(domain1);
			br3.newLine();
		}
		br2.close();
		br3.close();
		
		sc.close();
	}

}

