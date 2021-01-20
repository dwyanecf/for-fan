package com.fanchen.clearmind.indeed;

public class BadgeAccess {

	
	/**
	 * badge_records = [
	  ["Martha",   "exit"],
	  ["Paul",     "enter"],. 1point3acres.com/bbs
	  ["Martha",   "enter"],
	  ["Martha",   "exit"],
	  ["Jennifer", "enter"],. more info on 1point3acres.com
	  ["Paul",     "enter"],. From 1point 3acres bbs
	  ["Curtis",   "enter"],
	  ["Paul",     "exit"],
	  ["Martha",   "enter"],
	  ["Martha",   "exit"],
	  ["Jennifer", "exit"],
	]
	find_mismatched_entries(badge_records)
	Expected output: ["Paul", "Curtis"], ["Martha"]
	 */
	
	
	
//	function invalidBadgeRecords(records) {
//		  if (!records || records.length === 0) {
//		    return [];
//		  }
//		  const result = [[], []];
//		  // 0 for exited, 1 for entered
//		  const state = new Map();
//		  const invalidEnter = new Set();
//		  const invalidExit = new Set();
//		  for (const [name, action] of records) {
//		    !state.has(name) && state.set(name, 0);
//		    if (action === 'enter') {
//		      if (state.get(name) === 0) {
//		        state.set(name, 1);
//		      } else {
//		        invalidEnter.add(name);
//		      }
//		    } else {
//		      if (state.get(name) === 1) {
//		        state.set(name, 0);
//		      } else {
//		        invalidExit.add(name);
//		      }
//		    }
//		  }
//		  for (const [name, s] of state) {
//		    if (s === 1) {
//		      invalidEnter.add(name);
//		    }
//		  }
//		  for (const name of invalidEnter) {
//		    result[0].push(name);
//		  }
//		  for (const name of invalidExit) {
//		    result[1].push(name);
//		  }
//		  return result;
//		}
	
	
	
	
	
	
	
	
	
	
	
//	function frequentAccess(records) {
//		  if (!records || records.length === 0) {
//		    return [];
//		  }
//		  const result = [];
//		  const times = new Map();
//		  for (const [name, timestamp] of records) {
//		    if (times.has(name)) {
//		      times.get(name).push(timestamp);
//		    } else {
//		      times.set(name, [timestamp]);
//		    }
//		  }
//		  for (const [name, timestamps] of times) {
//		    timestamps.sort(timeDifference);
//		    let i = 0;
//		    let timewindow = [timestamps[i]];
//		    for (let j = 1; j < timestamps.length; j++) {
//		      if (timeDifference(timestamps[i], timestamps[j]) < 60) {
//		        timewindow.push(timestamps[j]);
//		      } else {
//		        timewindow = [timestamps[j]];
//		        i = j;
//		      }
//		    }
//		    if (timewindow.length >= 3) {
//		      result.push([name, timewindow]);
//		    }
//		  }
//		  return result;
//		}
//
//		function timeDifference(a, b) {
//		  const aHour = Math.floor(a / 100);
//		  const bHour = Math.floor(b / 100);
//		  const aMinute = a % 100;
//		  const bMinute = b % 100;
//		  return aHour * 60 + aMinute - (bHour * 60 + bMinute);
//		}
	
}
