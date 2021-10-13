package com.neosoft.session;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFile {

	public static void main(String[] args) {
		BufferedReader reader = null;
		int wordCount = 0;
		int lineCount = 0;
		File file = new File("resources/test.txt");
		if(file.exists()) {
			try {
				reader = new BufferedReader(new FileReader(file));
				File testCopy = new File("resources/testCopy.txt");
				BufferedReader br2 = new BufferedReader(new FileReader(testCopy));
				String line = br2.readLine();
				int flag = 0;
				while(line != null) {
					String[] word = line.split(" ");
					for(String s: word) {
						if(s.toLowerCase().equals("java")) {
							flag = 1;
							break;
						}
						else {
							flag = 0;
						}
					}
					line = br2.readLine();
							
				}
				br2.close();
				if(flag == 1) {
					BufferedWriter br1 = new BufferedWriter(new FileWriter(testCopy,true));
					
					String currentLine = reader.readLine();
					while(currentLine != null) {
						br1.newLine();
						br1.write(currentLine);
						lineCount++;
						String[] words = currentLine.split(" ");
						
		                wordCount = wordCount + words.length;
		                currentLine = reader.readLine();
					}
					System.out.println("Line Count: "+lineCount);
					System.out.println("Word Count: "+wordCount);
					reader.close();
					br1.close();
				}
				else {
					System.out.println("File does not contain java. Therefore can't write");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("File does not exist.");
		}
		
	}
}
