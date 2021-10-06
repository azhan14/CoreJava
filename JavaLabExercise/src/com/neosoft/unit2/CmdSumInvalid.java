package com.neosoft.unit2;

public class CmdSumInvalid {

	public static void main(String[] args) {
		int sum = 0,invalid = 0;
		for(int i = 0; i < args.length; i++) {
			try {
				sum += Integer.parseInt(args[i]);
			} catch(NumberFormatException e) {
				invalid++;
			}
		}
		
		System.out.println("Total number of arguments: "+args.length);
		System.out.println("Sum: "+sum);
		System.out.println("Invalid input: "+invalid);
	}
}
