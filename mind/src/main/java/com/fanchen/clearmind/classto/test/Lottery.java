package com.fanchen.clearmind.classto.test;

import java.util.HashSet;
import java.util.Set;

public class Lottery {
	public static void main(String[] args) {
		int res = 0;
		for (int i = 0; i < 10; i++) {
			res = getTheLottery() ? res + 1 : res;
		}
		System.out.println(res);
	}

	private static boolean getTheLottery() {
		int[] lottery = new int[190001];
		for (int i = 1; i < 190001; i++) {
			lottery[i] = i;
		}
		Set<Integer> set = new HashSet<>();
		return firstPick(lottery,set)||secondPick(lottery,set);

	}

	private static boolean firstPick(int[] lottery, Set<Integer> set) {
		for (int i = 0; i < 20000; i++) {
			int random = (int) (Math.random() * 95000);
			while(!set.add(random)){
				random = (int) (Math.random() * 95000);
			}
			if( random == 5130)
				return true;
			
		}
		return false;
	}

	private static boolean secondPick(int[] lottery, Set<Integer> set) {
		for (int i = 0; i < 65000; i++) {
			int random = (int) (Math.random() * 190000);
			while(!set.add(random)){
				random = (int) (Math.random() * 190000);
			}
			if( random == 5130)
				return true;
		}
		return false;
	}

}
