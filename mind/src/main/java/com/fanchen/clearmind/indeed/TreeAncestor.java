package com.fanchen.clearmind.indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeAncestor {
/**
 * parentChildPairs = [  (1, 3), (2, 3), (3, 6), (5, 6),
                   (5, 7), (4, 5), (4, 8), (8, 10)  ] 


findNodesWithZeroAndOneParents(parentChildPairs) =>
                                  [ [1, 2, 4],    // Individuals with zero parents
                                  [5, 7, 8, 10] // Individuals with exactly one parent ]

 */
	
	
public static List<List<Integer>> commonAncestor1(int[][] pairs) {
	// assume non-empty input 2-d array, and each pair contains 2 elements with
	// parent-child order
	List<Integer> zero_ancestor = new ArrayList<>(), one_ancestor = new ArrayList<>();
	Map<Integer, Integer> numOfAncestors = new HashMap<>();
	for (int[] pair : pairs) {
		numOfAncestors.put(pair[1], numOfAncestors.getOrDefault(pair[1], 0) + 1);
		numOfAncestors.put(pair[0], numOfAncestors.getOrDefault(pair[0], 0));
	}
	for (int node : numOfAncestors.keySet()) {
		if (numOfAncestors.get(node) == 0)
			zero_ancestor.add(node);
		if (numOfAncestors.get(node) == 1)
			one_ancestor.add(node);
	}
	List<List<Integer>> ans = new ArrayList<>();
	ans.add(zero_ancestor);
	ans.add(one_ancestor);
	return ans;
}


/**
 * hasCommonAncestor(parentChildPairs, 3, 8) => false
hasCommonAncestor(parentChildPairs, 5, 8) => true
hasCommonAncestor(parentChildPairs, 6, 8) => true
hasCommonAncestor(parentChildPairs, 1, 3) => false

 */
public static boolean commonAncestor2(int[][] pairs, int node1, int node2) {
	Set<Integer> p1 = new HashSet<>(), p2 = new HashSet<>();
	help_commonAncestor2(p1, node1, pairs);
	help_commonAncestor2(p2, node2, pairs);
	for (int parent : p1) {
		if (p2.contains(parent))
			return true;
	}
	return false;
}

public static void help_commonAncestor2(Set<Integer> parents, int node, int[][] pairs) {
	for (int[] pair : pairs) {
		if (pair[1] == node) {
			parents.add(pair[0]);
			help_commonAncestor2(parents, pair[0], pairs);
		}
	}
}



	
}
