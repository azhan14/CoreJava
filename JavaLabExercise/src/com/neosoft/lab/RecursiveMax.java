package com.neosoft.lab;

public class RecursiveMax {

	public static void main(String[] args) {
		int[] a = {12,25,4,99,35};
		int max = recurMax(a, a.length);
		System.out.println("Maximum Element: "+max);

	}
	
	static int recurMax(int[] arr, int length) {
		if(length == 1) {
			return arr[0];
		}
		return max(recurMax(arr, length-1),arr[length -1]);
	}
	
	private static int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}
}
