package com.fanchen.clearmind.ebay;

public class LC796RotateString {
	public boolean rotateString(String A, String B) {
		if (B.length() < A.length())
			return false;
		return (A + A).contains(B);
	}
}
