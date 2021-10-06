package com.neosoft.unit2;

public class ArrayExercise {

	public static void main(String[] args) {
		
		int[] IntArr = {12,13,14,15,16,17,18,19};
		System.out.println("Length of Int array: "+IntArr.length);
		
		double[] DoubleArr = {1.0,2.0,3.0,4.0,5.0};
		System.out.println("Length of Double array: "+DoubleArr.length);
		
		String[] str = {"Java","CPP","C"};
		System.out.println("Length of String array: "+str.length);
		
		System.out.println("==========================");
		//Declaration
		// 1 Dimensional Array
		int[] number;
		number = new int[5];
		number[0] = 1;
		number[1] = 2;
		number[2] = 3;
		number[3] = 4;
		number[4] = 5;
		System.out.println("One Dimensional Array:");
		for(int i:number) {
			System.out.print(i+" ");
		}
		System.out.println(" ");
		System.out.println("==========================");
		System.out.println("Two Dimensional Array:");
		
		// 2 Dimensional Array
		int[][] twoDimArr = {{2,3},{4,5}};
		for(int i = 0; i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.print(twoDimArr[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("==========================");
		int[][] TwoDArr = new int[2][3];
		TwoDArr[0][0] = 1;
		TwoDArr[0][1] = 2;
		TwoDArr[0][2] = 3;
		TwoDArr[1][0] = 4;
		TwoDArr[1][1] = 5;
		TwoDArr[1][2] = 6;
		for(int i = 0; i<2;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(TwoDArr[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("==========================");
		System.out.println("Multi Dimensional Array:");
		
		int[][][] MultiDArray = {{{1,2},{3,4}},{{5,6},{7,8}}};
		for(int i = 0; i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					System.out.println("arr["+i+"]["+j+"]["+k+"] = "+MultiDArray[i][j][k]);
				}
			}
		}
	}

}
