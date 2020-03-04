/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.a.tools;

import javax.xml.bind.DatatypeConverter;

/**
 * @author Fan Chen
 *
 */
public class HexToEBCDIC {
	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	public static void main(String[] args) throws java.lang.Exception {
		String hexadecimal3 = "D240404040404040";
		byte[] ebcdic = hexStringToByteArray(hexadecimal3);
		System.out.println(new String(ebcdic, "Cp273")); // prints 1234

		System.out.println(new String(DatatypeConverter.parseHexBinary(hexadecimal3), "CP1047"));
	}

}
