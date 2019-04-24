package com.fanchen.clearmind.concept;

public class Loops {
	public static void main(String[] args) {
		// 1. while loop
		whileLoop();

		// 2. do-while loop
		doWhileLoop();

		// 3. for loop
		forLoop();

	}

	private static void forLoop() {
		for (int i = 1; i <= 100; i = i * 2) {
			if (i == 4) {
				continue;
			}
			System.out.println("This is i: " + i);
		}
	}

	private static void doWhileLoop() {
		int i = 1;
		do {
			System.out.println("this is i: " + i);
			i--;
			break;
		} while (i >= 0);
	}

	private static void whileLoop() {
		int i = 5;
		while (i >= 0) {
			if (i == 2) {
				break;
			}
			System.out.println("this is i: " + i);
			i--;
		}
	}
}
