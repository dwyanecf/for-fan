package com.fanchen.clearmind.indeed.vo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class QueryRecommendation {

	
	/**
	 * 给出若干行的文字，再给query，输出所在的行数。行数要排序。先根据出现的频率排序，如果频率一样，
		就按照行数大小来排序。
		举例：
		a b     //1
		b a a   //2
		a b b   //3
		a       //4
		query(a),输出就是（2，1，3,4），query(b)输出(3,1,2)
		query(a & b) 输出(2,3,1)
		query(a | b) 输出(2,3,1,4)
		因为query(a&b)(a|b)的频率计算都是单独算a和b出现次数然后求和的。
		只不过或的时候更宽容一点儿吧，有一个就行，与的时候要两个都在。
		
		据说上机题只需要用到hashmap。
		然后计算频率的时候看清楚一些就行吧。
		还有上机题需要scanner么？
		
		暂时没什么想法，除了暴力做之外，可以把每个词的query单独拎出来，然后遇到a&b的时候就比较好做了。
		上机只有一轮，90分钟，看命了。
	 */
	
	// word, <line, count>
	Map<String, PriorityQueue<int[]>> alphaMap ;
	
	
	public QueryRecommendation(List<String> lines) {
		alphaMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(String line: lines) {
			sb.append(line).append(" ");
		}
		String[] allWords = sb.toString().split(" ");
		Set<String> set = new HashSet<>();
		for(String word: allWords) {
			set.add(word);
		}
		
		for(String word: set) {
			alphaMap.put(word, new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]));
		}

		for (int i = 0; i < lines.size(); i++) {
			String[] curLine = lines.get(i).split(" ");
			

		}
	}
}
