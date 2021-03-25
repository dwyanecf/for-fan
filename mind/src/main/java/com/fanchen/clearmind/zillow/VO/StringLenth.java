package com.fanchen.clearmind.zillow.VO;

public class StringLenth {
	public int getLen(String str) {

		// if we reach at the end of the string
		if (str.equals(""))
			return 0;
		else
			return getLen(str.substring(1)) + 1;
	}
}
