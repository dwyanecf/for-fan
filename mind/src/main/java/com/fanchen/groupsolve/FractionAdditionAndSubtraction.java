/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.groupsolve;

import java.util.Scanner;

/**
 * @author Fan Chen
 *
 */

public class FractionAdditionAndSubtraction {
    /*
    *  The (?=) part is a zero-width positive lookahead.
    *  Since [-,+] means - or +,
    *  the regex (?=[-,+]) means the next element is either - or +.

    *  Since | is logical or operator,
    *  "/|(?=[-+])" means the element is "/",
    *  or the next element is either - or +.
    *  For example, when expression = "-1/2+1/2-1/3",

    *  Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])")
    *  generates [-1, 2, +1, 2, -1, 3 ].
    *  `Note that the signs - and + are preserved.
    *
    *
    * A/B+a/b = (Ab+aB)/Bb;
    * but cancel their greatest common divisor
    * 
    * */
	public static String fractionAddition(String expression) {
		Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-,+])");
		int A = 0, B = 1;
		while (sc.hasNext()) {
			int a = sc.nextInt(), b = sc.nextInt();
			A = A * b + B * a;
			B = B * b;
			int g = gcd(A, B);
			A /= g;
			B /= g;
		}
		return A + "/" + B;
	}

	public static int gcd(int a, int b) {
		return a != 0 ? gcd(b % a, a) : Math.abs(b);
	}
	
	public static void main(String[] args) {
		fractionAddition("-1/2+1/2-1/3");
	}
}
