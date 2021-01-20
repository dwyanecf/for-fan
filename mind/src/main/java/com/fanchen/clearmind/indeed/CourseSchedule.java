package com.fanchen.clearmind.indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {
	public static List<String> courseSchedule1(String[][] pairs){
	    List<String> ans = new ArrayList<>();
	    HashMap<String,HashSet<String>> student_courses = new HashMap<>();
	    for(String[] pair : pairs){
	        String id = pair[0], cur_course = pair[1];
	        if(student_courses.containsKey(id)) student_courses.get(id).add(cur_course);
	        else{
	            HashSet<String> course_list = new HashSet<>();
	            course_list.add(cur_course);
	            student_courses.put(id, course_list);
	        }
	    }
	    for(String s1 : student_courses.keySet()){
	        HashSet<String> course_s1 = student_courses.get(s1);
	        for(String s2 : student_courses.keySet()){
	            if(s1 == s2) continue;
	            StringBuilder cur_pair = new StringBuilder();
	            cur_pair.append("[" + s1 + ", " + s2 + "]: [" );
	            for(String course : student_courses.get(s2)){
	                if(course_s1.contains(course)){
	                    cur_pair.append(course + " ");
	                }
	            }
	            cur_pair.append("]");
	            ans.add(cur_pair.toString());
	            ans.add("\n");
	        }
	    }
	    return ans;
	}

}
