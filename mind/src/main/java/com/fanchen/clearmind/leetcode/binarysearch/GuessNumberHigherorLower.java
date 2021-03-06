package com.fanchen.clearmind.leetcode.binarysearch;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or
 * lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results
 * (-1, 1, or 0):
 * <p>
 * -1 : My number is lower 1 : My number is higher 0 : Congrats! You got it!
 * Example: n = 10, I pick 6.
 * <p>
 * Return 6.
 */
public class GuessNumberHigherorLower {

	public int guessNumber(int n) {
		int lo = 1;
		int hi = n;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int guess = guess(mid);
			if (guess == 0)
				return mid;
			else if (guess == 1) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return hi;
	}

	/*
	 * The guess API is defined in the parent class GuessGame.
	 * 
	 * @param num, your guess
	 * 
	 * @return -1 if my number is lower, 1 if my number is higher, otherwise return
	 * 0
	 */
	int guess(int num) {
		return 0;
	}
}
