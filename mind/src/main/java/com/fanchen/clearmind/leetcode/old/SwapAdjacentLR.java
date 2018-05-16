package com.fanchen.clearmind.leetcode.old;

/**
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a
 * move consists of either replacing one occurrence of "XL" with "LX", or
 * replacing one occurrence of "RX" with "XR". Given the starting string start
 * and the ending string end, return True if and only if there exists a sequence
 * of moves to transform one string to the other.
 * 
 * Example:
 * 
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX" Output: True Explanation: We
 * can transform start to end following these steps: RXXLRXRXL -> XRXLRXRXL ->
 * XRLXRXRXL -> XRLXXRRXL -> XRLXXRRLX
 * 
 * @author fan
 *
 */
public class SwapAdjacentLR {

	public boolean canTransform(String start, String end) {

		if (start == null && end == null)
			return true;
		if (start.length() != end.length())
			return false;

		int pointer1 = 0;
		int pointer2 = 0;

		while (true) {

			while (pointer1 < start.length() && start.charAt(pointer1) == 'X') {
				pointer1++;
			}
			while (pointer2 < end.length() && end.charAt(pointer2) == 'X') {
				pointer2++;
			}

			if (pointer1 == start.length() && pointer2 == end.length()) {
				return true;
			} else if (pointer1 == start.length() || pointer2 == end.length()) {
				return false;
			}
			if (start.charAt(pointer1) != end.charAt(pointer2)) {
				return false;
			} else {
				if (start.charAt(pointer1) == 'R') {
					if (pointer2 < pointer1)
						return false;
				} else {
					if (pointer1 < pointer2)
						return false;
				}
				pointer1++;
				pointer2++;
			}

		}
	}
}
