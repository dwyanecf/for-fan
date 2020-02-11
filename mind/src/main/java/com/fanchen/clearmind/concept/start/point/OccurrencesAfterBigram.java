/*
 * Copyright (C) 2019 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.concept.start.point;

import java.util.ArrayList;
import java.util.List;

/**
 * Given words first and second, consider occurrences in some text of the form
 * "first second third", where second comes immediately after first, and third
 * comes immediately after second.
 * 
 * For each such occurrence, add "third" to the answer, and return the answer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: text = "alice is a good girl she is a good student", first = "a",
 * second = "good" Output: ["girl","student"] Example 2:
 * 
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 * 
 * 
 * Note:
 * 
 * 1 <= text.length <= 1000 text consists of space separated words, where each
 * word consists of lowercase English letters. 1 <= first.length, second.length
 * <= 10 first and second consist of lowercase English letters.
 * 
 * @author Fan Chen
 *
 */
public class OccurrencesAfterBigram {
	public String[] findOcurrences(String text, String first, String second) {
		List<String> res = new ArrayList<>();
		String[] words = text.split(" ");
		int n = words.length;
		int i = 0;
		while (i < n - 1) {
			if (words[i].equals(first) && words[i + 1].equals(second)) {
				if (i + 2 < n) {
					res.add(words[i + 2]);
				}
			}
			i++;
		}
		return res.toArray(new String[0]);

	}

}
