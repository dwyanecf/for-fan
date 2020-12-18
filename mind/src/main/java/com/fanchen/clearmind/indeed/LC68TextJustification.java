package com.fanchen.clearmind.indeed;

import java.util.ArrayList;
import java.util.List;

public class LC68TextJustification {

	/**
	 * Input: words = ["This", "is", "an", "example", "of", "text",
	 * "justification."], maxWidth = 16 Output: [ "This is an", "example of text",
	 * "justification. " ]
	 * 
	 * @param words
	 * @param maxWidth
	 * @return
	 */
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<>();
		int left = 0;
		while (left < words.length) {
			int right = findRightIndex(left, words, maxWidth);
			list.add(prepareLine(left, right, words, maxWidth));
			left = right + 1;
		}
		return list;
	}

	public int findRightIndex(int left, String[] words, int maxWidth) {
		int right = left;
		int sum = words[right++].length();
		while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
			sum += 1 + words[right++].length();
		}
		return right - 1;
	}

	public String prepareLine(int left, int right, String[] words, int maxWidth) {
		if (left == right) {
			return addPadding(words[left], maxWidth);
		}
		boolean lastLine = (right == words.length - 1);
		int numOfPadding = right - left;
		int totalPadding = maxWidth - getWordLength(left, right, words);

		String padding = lastLine ? "-" : generatePadding(totalPadding / numOfPadding);
		int remain = lastLine ? 0 : (totalPadding % numOfPadding);

		StringBuilder sb = new StringBuilder();
		for (int i = left; i <= right; i++) {
			sb.append(words[i]);
			sb.append(padding);
			sb.append(remain > 0 ? "-" : "");
			remain--;
		}
		return addPadding(sb.toString().trim(), maxWidth);
	}

	public String addPadding(String word, int maxWidth) {
		return word + generatePadding(maxWidth - word.length());
	}

	public String generatePadding(int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	public int getWordLength(int left, int right, String[] words) {
		int len = 0;
		for (int i = left; i <= right; i++) {
			len += words[i].length();
		}
		return len;
	}

}
