package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class LC721AccountMerge {

	/**
	 * Input: accounts = 
	 * [["John", "johnsmith@mail.com", "john00@mail.com"],
	 * ["John", "johnnybravo@mail.com"], 
	 * ["John", "johnsmith@mail.com", "john_newyork@mail.com"], 
	 * ["Mary", "mary@mail.com"]] 
	 * 
	 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'], 
	 * ["John", "johnnybravo@mail.com"], 
	 * ["Mary", "mary@mail.com"]] 
	 * 
	 * Explanation: The first
	 * and third John's are the same person as they have the common email
	 * "johnsmith@mail.com". The second John and Mary are different people as none
	 * of their email addresses are used by other accounts. We could return these
	 * lists in any order, for example the answer [['Mary', 'mary@mail.com'],
	 * ['John', 'johnnybravo@mail.com'], ['John', 'john00@mail.com',
	 * 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
	 * 
	 * @param accounts
	 * @return
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		// email <-> user
		Map<String, String> owners = new HashMap<>();

		// email <-> masterEmail
		Map<String, String> parents = new HashMap<>();
		Map<String, TreeSet<String>> unions = new HashMap<>();
		for (List<String> a : accounts) {
			for (int i = 1; i < a.size(); i++) {
				owners.put(a.get(i), a.get(0));
				// every email parent point to itself
				parents.put(a.get(i), a.get(i));
			}
		}

		
		for (List<String> a : accounts) {
			String p = findParent(a.get(1), parents);
			for (int i = 2; i < a.size(); i++) {
				parents.put(findParent(a.get(i), parents), p);
			}
		}

		for (List<String> a : accounts) {
			String p = findParent(a.get(1), parents);
			if (!unions.containsKey(p)) {
				unions.put(p, new TreeSet<>());
			}
			for (int i = 1; i < a.size(); i++) {
				unions.get(p).add(a.get(i));
			}
		}
		List<List<String>> ans = new ArrayList<>();
		for (String p : unions.keySet()) {
			List<String> email = new ArrayList(unions.get(p));
			email.add(0, owners.get(p));
			ans.add(email);
		}
		return ans;
	}

	public String findParent(String p, Map<String, String> map) {
		return map.get(p) == p ? p : findParent(map.get(p), map);
	}
	
	
	/**
	 *  a b c // now b, c have parent a
		d e f // now e, f have parent d
		g a d // now abc, def all merged to group g
		
		parents populated after parsing 1st account: a b c
		a->a
		b->a
		c->a
		
		parents populated after parsing 2nd account: d e f
		d->d
		e->d
		f->d
		
		parents populated after parsing 3rd account: g a d
		g->g
		a->g
		d->g
	 */
}
