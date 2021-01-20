package com.fanchen.clearmind.indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MeetingRoom {

	
	 public boolean canAttendMeetings(int[][] intervals) {
	        if(intervals == null || intervals.length == 0) return true;
	        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
	        for(int i = 0; i<intervals.length-1; i++){
	            if(intervals[i][1] > intervals[i+1][0]){
	                return false;
	            }
	        }
	        return true;
	    }
	 
	 
	 
	 public int minMeetingRooms(int[][] intervals) {
	        int n  = intervals.length;
	        int[] starts = new int[n];
	        int[] ends = new int[n];
	        for(int i=0;i <n;i++){
	            starts[i] = intervals[i][0];
	            ends[i] = intervals[i][1];
	        }
	        Arrays.sort(starts);
	        Arrays.sort(ends);
	        int count = 0;
	        int roomFinished = 0;
	        for(int i=0;i<n;i++){
	            if(ends[roomFinished]<= starts[i]){
	                roomFinished++;
	            }else{
	                count++;
	            }
	        }
	        return count;
	    }
	 
	 
	 
	 
	 public int[][] merge(int[][] intervals) {
	        if(intervals==null || intervals.length ==0) return intervals;
	        List<int[]> list = new ArrayList<>();
	        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
	        list.add(intervals[0]);
	        int[] cur = intervals[0];
	        for(int i =1; i< intervals.length; i++){
	            if(cur[1]>= intervals[i][0]){
	                cur[1] = Math.max(cur[1], intervals[i][1]);
	            }else{
	                cur = intervals[i];
	                list.add(cur);
	            }
	        }
	        return list.toArray(new int[list.size()][2]);
	    }
	 
	 
	 
	 public static List<List<Integer>> meetingRooms2(int[][] intervals){
		    List<List<Integer>> ans = new ArrayList<>();
		    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
		    LinkedList<int[]> cur = new LinkedList<>();
		    for(int[] pair : intervals){
		        if(cur.isEmpty() || cur.getLast()[1] < pair[0]) cur.add(pair);
		        else{
		            cur.getLast()[1] = Math.max(cur.getLast()[1], pair[1]);
		        }
		    }
		    List<Integer> Start_interval = new ArrayList<>();
		    Start_interval.add(0);
		    Start_interval.add(cur.get(0)[0]);
		    ans.add(Start_interval);
		    for(int i = 0; i < cur.size() - 1; i++){
		        List<Integer> cur_interval = new ArrayList<>();
		        cur_interval.add(cur.get(i)[1]);
		        cur_interval.add(cur.get(i + 1)[0]);
		        ans.add(cur_interval);
		    }
		    return ans;
		}

	 
	 
	 
	 
	 
}
