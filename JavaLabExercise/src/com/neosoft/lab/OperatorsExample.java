package com.neosoft.lab;

public class OperatorsExample {

	public static void main(String[] args) {
		OperatorsExample ObjOp = new OperatorsExample();
		ObjOp.IncrementDecrement();
		ObjOp.BitwiseCompliment();
		ObjOp.ArithmeticOp();
		ObjOp.RelationalOp();
		ObjOp.BitwiseOp();
		ObjOp.ConditinalOp();
	}
	
	void IncrementDecrement() {
		System.out.println("Increment & Decrement Operator: ");
		int a =1;
		//Increment Operator
		int n = a++;	//post increment: assigning value of a i.e. 1 to n and then increment a
		System.out.println("n: "+n+" a: "+a);
		// output: n: 1 a: 2
		
		int b = ++a;	//pre increment: incrementing a from 2 to 3 and then assigning value 3 to b
		System.out.println("b: "+b+" a: "+a);
		// output: b: 3 a: 3
		
		//Decrement Operator
		int c = a--;	//post decrement: assigning value of a i.e. 3 to c and then decrementing a
		System.out.println("c: "+c+" a: "+a);
		// output: c: 3 a: 2
		
		int d = --a;	//pre decrement: decrementing a from 2 to 1 and then assigning value 1 to d
		System.out.println("d: "+d+" a: "+a);
		// output: d: 1 a: 1
		
		System.out.println("=========================================");
	}
	
	void BitwiseCompliment() {
		System.out.println("Bitwise Compliment Operator: ");
		int a = 10;
		System.out.println("a: "+a);
		// a = 10(decimal) = 1010(Binary)
		// 1's complement of 1010 = 0101 = 5(decimal)
		// 2's complement of 5: 0101 = 1010(1's compliment) = 1011(2's compliment) = -11
		System.out.println("Bitwise Compliment of a: "+(~a));
		
		int b = 7;
		System.out.println("b: "+b);
		// b = 7(decimal) = 0111(Binary)
		// 1's complement of 0111 = 1000 = 8(decimal)
		// 2's complement of 8: 1000 = 0111(1's compliment) = 1000(2's compliment) = -8
		System.out.println("Bitwise Compliment of b: "+(~b));
		
		System.out.println("=========================================");
	}
	
	void ArithmeticOp() {
		System.out.println("Arithmetic Operator: ");
		int a = 14, b = 6;
		
		// Addition Operator
		System.out.println("a + b = "+(a+b));
		
		// Subtraction Operator
		System.out.println("a - b = "+(a-b));
		
		// Multiplication Operator
		System.out.println("a * b = "+(a*b));
		
		//Division Operator
		System.out.println("a / b = "+(a/b)); // a and b are integer, therefore o/p is integer
		System.out.println("14.0 / b = "+(14.0/b)); // if one operand is floating then output is floating number
		System.out.println("a / 6.0 = "+(a/6.0));
		
		//Modulo Operator
		System.out.println("a % b = "+(a%b)); // modulo gives remainder: remainder of 14/6 is 2.
		System.out.println("=========================================");
	}
	
	void RelationalOp() {
		System.out.println("Arithmetic Operator: ");
		
		int a = 7, b = 12;
		
		// == operator
		System.out.println(a == b); //return true if values are equal else false
		
		// != operator
		System.out.println(a != b); // return true if values are not equal else false
		
		// > operator
		System.out.println(a > b); // return true if a is greater than b else false
		
		// < operator
		System.out.println(a < b); // return true if a is smaller than b else false
		
		// >= operator
		System.out.println(a >= b); // return true if a is greater than equal to b else false
		
		// <= operator
		System.out.println(a <= b); // return true if a is smaller than equal to b else false
		
		System.out.println("=========================================");
	}
	
	void BitwiseOp() {
		System.out.println("Bitwise Operator: ");
		int a = 9, b =6;
		
		//Bitwise AND (&)
		// returns 1 if both bits are 1 else 0
		// 9   = 1001
		// 6   = 0110 
		// o/p = 0000
		System.out.println("a & b: "+(a&b));
		
		//Bitwise OR (|)
		// returns 1 if one of the bit is 1 else 0
		// 9   = 1001
		// 6   = 0110 
		// o/p = 1111
		System.out.println("a | b: "+(a|b));
		
		//Bitwise XOR (^)
		// returns 0 if both bits are same else 0
		// 9   = 1001
		// 6   = 0110 
		// o/p = 1111
		System.out.println("a ^ b: "+(a^b));
		
		// 10   = 1010
		// 6    = 0110 
		// o/p  = 1100
		System.out.println("10 ^ b: "+(10^b));
		
		// Right Shift
		// a = 9 = 1001
		// a>>2 = 9>>2 = 0010 = 2
		System.out.println("a >> 2: "+(a>>2));
		
		// left Shift
		// b = 6 = 0110
		// b<<2 = 6<<2 = 0001 1000 = 24
		System.out.println("b << 2: "+(b<<2));
		
		// Unsigned right shift
		// 240 = 1111 0000 
		// 240 >>> 2 = 0011 1100 = 60
		System.out.println("240 >>> 2: "+(240>>>2));
		
		System.out.println("=========================================");
	}
	
	void ConditinalOp() {
		System.out.println("Conditional Operator: ");
		
		int x = 5, y= 6, z = 7;
		
		// && Operator
		System.out.println((x<y) && (y<z)); // true && true = true
		System.out.println((x<y) && (z<x)); // true && false = false
		
		// || Operator
		System.out.println((x<y) || (y<z)); // true || true = true
		System.out.println((x<y) || (z<x)); // true || false = true
		System.out.println((y<x) || (z<x)); // false || false = false
		
		// ternary Operator
		int a = (x == 1)?42:69; // condition? true: false
		System.out.println(a);
		int b = (x == 5)?42:69;
		System.out.println(b);
		
		System.out.println("=========================================");
	}
	
}
