package com.fanchen.clearmind.leetcode.map.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
 * have a list of favorite restaurants represented by strings.
 * 
 * You need to help them find out their common interest with the least list
 * index sum. If there is a choice tie between answers, output all of them with
 * no order requirement. You could assume there always exists an answer.
 * 
 * Example 1: Input: ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 
 * Output: ["Shogun"] Explanation: The only restaurant they both like is
 * "Shogun".
 * 
 * Example 2: Input: ["Shogun", "Tapioca Express", "Burger King", "KFC"] ["KFC",
 * "Shogun", "Burger King"]
 * 
 * Output: ["Shogun"] Explanation: The restaurant they both like and have the
 * least index sum is "Shogun" with index sum 1 (0+1). Note:
 * 
 * @author fan
 *
 */
public class MinimumIndexSumTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {

		Map<String, Integer> nameMap = new HashMap<>();
		Map<String, Integer> valueMap = new HashMap<>();

		for (int i = 0; i < list1.length; i++) {
			nameMap.put(list1[i], i);
		}

		for (int j = 0; j < list2.length; j++) {
			if (nameMap.get(list2[j]) != null) {
				valueMap.put(list2[j], j + nameMap.get(list2[j]));
			}
		}
		int minValue = Integer.MAX_VALUE;
		for (Integer currentValue : valueMap.values()) {
			if (currentValue < minValue) {
				minValue = currentValue;
			}
		}

		List<String> answerList = new ArrayList<>();

		for (String key : valueMap.keySet()) {
			int v = valueMap.get(key);
			if (v == minValue) {
				answerList.add(key);
			}
		}

		return answerList.stream().toArray(String[]::new);
	}
}
