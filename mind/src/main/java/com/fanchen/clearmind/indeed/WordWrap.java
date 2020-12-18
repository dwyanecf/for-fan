package com.fanchen.clearmind.indeed;

import java.util.ArrayList;
import java.util.List;

public class WordWrap {

//    e.g. ["1p3acres", "is", "a", "good", "place", "to", "communicate"], 12 
// => {"1p3acres-is", "a-good-place", "for", "communicate"}

	public static List<String> wrapLines1(String[] words, int maxLength) {
		List<String> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int p = 0;
		while (p < words.length) {
			if (sb.length() == 0)
				// assume all words length no exceed to maxLength
				sb.append(words[p++]);

			else if (sb.length() + 1 + words[p].length() <= maxLength) {
				sb.append('-');
				sb.append(words[p++]);
			} else {
				ans.add(sb.toString());
				sb.setLength(0);
			}
		}
		if (sb.length() != 0)
			ans.add(sb.toString());
		return ans;
	}

//	e.g. ["123 45 67 8901234 5678", "12345 8 9 0 1 23"], 10 
//	=> {"123--45-67", "8901234", "5678-12345", "8-9-0-1-23"}
	
//	["123 45 67 8901234 5678", "12345 8 9 0 1 23"], 15 
///	=> {"123----45----67", "8901234----5678", "12345---8--9--0", "23"}	
	
	
	

}
