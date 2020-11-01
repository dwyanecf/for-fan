package com.fanchen.clearmind.leetcode.yama.vo;

public class LC165CompareVersion {

	public int compareVersion(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
		String[] levels2 = version2.split("\\.");

		int length = Math.max(levels1.length, levels2.length);
		for (int i = 0; i < length; i++) {
			Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			if (compare != 0) {
				return compare;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		LC165CompareVersion lc = new LC165CompareVersion();
		int r1 = lc.compareVersion("7.5.2.4", "7.5.3");
		int r2 = lc.compareVersion("1.0.1", "1");
		int r3 = lc.compareVersion("1.0.0", "1");
		int r4 = lc.compareVersion("1.01", "1.001");
	}
}
