package com.fanchen.clearmind.indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendCycle {

	/**
	 * Sample Input: employees = [ "1, Bill, Engineer", "2, Joe, HR", "3, Sally,
	 * Engineer", "4, Richard, Business", "6, Tom, Engineer" ]
	 * 
	 * friendships = [ "1, 2", "1, 3", "3, 4" ]
	 * 
	 * Output: 1: 2, 3 
	 * 		   2: 1 
	 *         3: 1, 4 
	 *         4: 3 
	 *         6: None
	 */
	public static List<String> friendCycle1(String[] employees, String[] friendships) {
		 List<String> ans = new ArrayList<>();
		    Map<String,List<String>> friend_list = new HashMap<>();
		    for(int i = 0; i < employees.length; i++){
		        String[] split_res = employees[i].split(",");

		        friend_list.put(split_res[0], new ArrayList<String>());
		    }
		    for(String pair : friendships){
		        //chris is friend with martin, martin is friend with chris
		        String[] sep = pair.split(",");
		        String chris = sep[0];
		        String[] meaningless_split = sep[1].split(" ");
		        String martin = meaningless_split[1];
		        friend_list.get(chris).add(martin);
		        friend_list.get(martin).add(chris);
		    }
		    // iterate friend list, if list is empty, too bad you get no friends ;(
		    for(String everyone : friend_list.keySet()){
		        StringBuilder ones_friends = new StringBuilder();
		        ones_friends.append(everyone);
		        ones_friends.append(": ");
		        if(friend_list.get(everyone).size() != 0)
		            ones_friends.append(friend_list.get(everyone));
		        else ones_friends.append("None");
		        ans.add(ones_friends.toString());
		    }
		    return ans;


	}
	
	
	/**
	 * Sample Output: Output: "Engineer: 2 of 3" "HR: 1 of 1" "Business: 1 of 1"
	 */
	public static List<String> friendCycle2(String[] employees, String[] friendships) {
		List<String> ans = new ArrayList<>();
		Map<String, List<String>> friend_list = new HashMap<>();
		for (int i = 0; i < employees.length; i++) {
			String[] split_res = employees[i].split(",");

			friend_list.put(split_res[0], new ArrayList<String>());
		}
		for (String pair : friendships) {
			// chris is friend with martin, martin is friend with chris
			String[] sep = pair.split(",");
			String chris = sep[0];
			String[] meaningless_split = sep[1].split(" ");
			String martin = meaningless_split[1];
			friend_list.get(chris).add(martin);
			friend_list.get(martin).add(chris);
		}
		// now we have each employee -> friends (list of strings) mapping
		Map<String, String> employee_department = new HashMap<>();
		Map<String, Integer> departments_num = new HashMap<>();
		for (String employee : employees) {
			String[] split_res = employee.split(",");
			String depart = split_res[2];
			String cur_depart = depart.substring(1, depart.length());
			employee_department.put(split_res[0], cur_depart);
			departments_num.put(cur_depart, departments_num.getOrDefault(cur_depart, 0) + 1);

		}
		// friend_list : employees -> all friends
		// employee_department : employees -> own department
		// departments_num : department -> nums of employees

		// iterate all departments, store department name and total number of employees
		// in a list of String
		Map<String, List<Integer>> info = new HashMap<>();// department name -> [total num, out of dep employees num]
		for (String dep : departments_num.keySet()) {
			List<Integer> val = new ArrayList<>();
			val.add(departments_num.get(dep));
			info.put(dep, val);
		}
		for (String individual : friend_list.keySet()) {
			String own_dep = employee_department.get(individual);
			for (String friend : friend_list.get(individual)) {
				String fri_dep = employee_department.get(friend);
				if (fri_dep != own_dep) {
					int update = departments_num.get(own_dep) - 1;
					departments_num.put(own_dep, update);
					break;
				}
			}
		}
		for (String dep : info.keySet()) {
			int hasOther = info.get(dep).get(0) - departments_num.get(dep);
			info.get(dep).add(hasOther);
		}
		for (String dep : info.keySet()) {
			StringBuilder sb = new StringBuilder();
			sb.append(dep);
			sb.append(": ");
			sb.append(info.get(dep).get(1));
			sb.append(" of ");
			sb.append(info.get(dep).get(0));
			ans.add(sb.toString());
		}

		return ans;
	}	
	
}
