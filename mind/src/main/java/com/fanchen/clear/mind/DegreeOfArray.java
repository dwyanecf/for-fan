package com.fanchen.clear.mind;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

	public int findShortestSubArray(int[] nums) {

		int degree=0;
		int n = nums.length;
		int minSize = n;
		Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		Map<Integer,Integer[]> map2 = new HashMap<Integer,Integer[]>();
		
		for(int i=0;i<n;i++) {
			map1.put(nums[i], map1.getOrDefault(nums[i],0)+1);
			degree = Math.max(degree, map1.get(nums[i]));
			
			if(map2.get(nums[i])==null) {
				map2.put(nums[i], new Integer[2]);
			}
			Integer[] index = map2.get(nums[i]);
			if(index[0]==null) index[0]=i;
			index[1]=i;
		}
		
		for(Map.Entry<Integer, Integer> entry: map1.entrySet()) {
			if(entry.getValue()!=degree) continue;
			Integer[] difference = map2.get(entry.getKey());
			minSize = Math.min(minSize, difference[1]-difference[0]);
		}
		return minSize;
		
	}

}
