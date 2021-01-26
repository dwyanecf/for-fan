package com.fanchen.clearmind.indeed.vo;

import java.util.List;
import java.util.Map;

public class RelatedWords {

	
	/**
	 * 第三轮：hackerrank做题，这道题是以前题的变形，输入是一堆query，每个query包含了user + query word, 输出是每当进来一个query时，根据之前的query，
	 * 要返回一个最相关的单词，这题能够保证同一个user，只会query某个单词一次。
		具体看例子：
		Input:
		7
		A python
		B java
		A java
		B php
		C python
		C java
		D java
		
		Output:
		0
		0
		0
		0
		1 java(因为目前A: pyhon java, B: java php, search过python的人中还search最多的是java，1次)
		1 python php(此时 A: pyhon java, B: java php, C: python)
		2 python(此时A: pyhon java, B: java php, C: python java)
		这道题我一开始一直在map如何设计上纠结着，naive的方法最后一直有三个case过不了，所以思考的过程是：
		map1<String, Set<String>> // user => the words he searched before
		大概能过6个case，开始优化
		加了个map2<String, List<String>> // word => list of users who searched this word before
		这个的话大概又过了4个，还是有三个过不了，此时我心怀侥幸，一直在优化中间的过程，而不是在优化思想了，结果没成功。直到最后还有20分钟时，换掉了思路，用了一个这个map
		map3<String, Map<String, Integer>> // word => related word and times
		这样的话，每次一个新词进来，直接就能找到相关的词，然后找到出现次数最多的就好。然后再利用map1中这个user之前query的结果，去update map3。
		这个思路没有debug完，思路讲给了面试官听，他肯定了这个想法。
	 */

	Map<String, Map<String, Integer>> wordsRelation;
	Map<String, List<String>> userWords;
	Map<String, Integer> wordMaxRelation;

	public RelatedWords(int n, List<String> lines) {
		
	}

}
