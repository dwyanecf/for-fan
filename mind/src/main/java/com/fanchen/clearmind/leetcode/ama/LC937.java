package com.fanchen.clearmind.leetcode.ama;

import java.util.Arrays;
import java.util.Comparator;

public class LC937 {
	/**
	 * You have an array of logs. Each log is a space delimited string of words.
	 * 
	 * For each log, the first word in each log is an alphanumeric identifier. Then,
	 * either:
	 * 
	 * Each word after the identifier will consist only of lower-case letters, or;
	 * Each word after the identifier will consist only of digits. We will call
	 * these two varieties of logs letter-logs and digit-logs. It is guaranteed that
	 * each log has at least one word after its identifier.
	 * 
	 * Reorder the logs so that all of the letter-logs come before any digit-log.
	 * The letter-logs are ordered lexicographically ignoring identifier, with the
	 * identifier used in case of ties. The digit-logs should be put in their
	 * original order.
	 * 
	 * Return the final order of the logs.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
	 * dig","let3 art zero"] Output: ["let1 art can","let3 art zero","let2 own kit
	 * dig","dig1 8 1 5 1","dig2 3 6"]
	 * 
	 * 
	 * @param logs
	 * @return
	 */
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, new LogComparator());
		return logs;
	}

	class LogComparator implements Comparator<String> {

		boolean isLetter(String[] word) {
			String word1 = word[1];
			char c = word1.charAt(0);
			return Character.isLetter(c);
		}

		@Override
		public int compare(String log1, String log2) {
			String[] words1 = log1.split(" ");
			String[] words2 = log2.split(" ");

			int word1Index = log1.indexOf(' ');
			int word2Index = log2.indexOf(' ');

			boolean isLetter1 = isLetter(words1);
			boolean isLetter2 = isLetter(words2);

			if (isLetter1 && isLetter2) {
				if (log1.substring(word1Index + 1).equals(log2.substring(word2Index + 1))) {
					return words1[0].compareTo(words2[0]);
				}
				return log1.substring(word1Index + 1).compareTo(log2.substring(word2Index + 1));
			} else if (isLetter1 || isLetter2) {
				return isLetter1 ? -1 : 1;
			} else {
				return 0;
			}
		}
	}
}
