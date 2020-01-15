package com.fanchen.groupsolve;

public class PowerOf10 {

	public boolean isPowerOfTen(int n) {
		if (n == 1)
			return true;
		if (n >= 0 && n <= 9)
			return false;
		return n % 10 == 0 && isPowerOfTen(n / 10);
	}

	public static void main(String[] args) {
		PowerOf10 obj = new PowerOf10();
		System.out.print(1 + "  ");
		System.out.println(obj.isPowerOfTen(1));
		System.out.print(0 + "  ");
		System.out.println(obj.isPowerOfTen(0));
		System.out.print(10 + "  ");
		System.out.println(obj.isPowerOfTen(10));
		System.out.print(5 + "  ");
		System.out.println(obj.isPowerOfTen(5));
		System.out.print(99 + "  ");
		System.out.println(obj.isPowerOfTen(99));
		System.out.print(100 + "  ");
		System.out.println(obj.isPowerOfTen(100));
		System.out.print(100000 + "  ");
		System.out.println(obj.isPowerOfTen(100000));
	}

}
