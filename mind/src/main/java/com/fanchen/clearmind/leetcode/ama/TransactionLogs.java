package com.fanchen.clearmind.leetcode.ama;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionLogs {

	/**
	 * Your Amazonian team is responsible for maintaining a monetary transaction
	 * service. The transactions are tracked in a log file. A log file is provided
	 * as a string array where each entry represents a transaction to service. Each
	 * transaction consists of:
	 * 
	 * sender_user_id, Unique identifier for the user that initiated the
	 * transaction. It consists of only digits with at most 9 digits.
	 * recipient_user_id: Unique identifier for the user that is receiving the
	 * transaction. It consists of only digits with at most 9 digits.
	 * amount_of_transaction: The amount of the transaction. It consists of only
	 * digits with at most 9 digits.
	 * 
	 * The values are separated by a space. For example, "sender_user_id
	 * recipient_user_id amount_of_transaction". Users that perform an excessive
	 * amount of transactions might be abusing the service so you have been tasked
	 * to identify the users that have a number of transactions over a threshold.
	 * The list of user ids should be ordered in ascending numeric value.
	 * 
	 * Example
	 * 
	 * logs = ["88 99 200", "88 99 300", "99 32 100", "12 12 15"]
	 * 
	 * threshold = 2
	 * 
	 * The transactions count for each user, regardless of role are:
	 * 
	 * ID Transactions
	 * 
	 * --- --------------
	 * 
	 * 99 3
	 * 
	 * 88 2
	 * 
	 * 12 1
	 * 
	 * 32 1
	 * 
	 * There are two users with at least threshold = 2 transactions: 99 and 88. In
	 * ascending order, the return arra is ['88', '99'].
	 */

	public static String[] processLogFile(String[] logs, int threshold) {
		Map<Long, Integer> userTransactions = new HashMap<>();
		if (logs == null || logs.length == 0)
			return null;
		for (String log : logs) {
			String[] values = log.split(" ");
			Long user1 = Long.parseLong(values[0]);
			Long user2 = Long.parseLong(values[1]);
			if (user1 != user2) {
				userTransactions.put(user1, userTransactions.getOrDefault(user1, 0) + 1);
				userTransactions.put(user2, userTransactions.getOrDefault(user2, 0) + 1);
			} else {
				userTransactions.put(user1, userTransactions.getOrDefault(user1, 0) + 1);
			}
		}
		List<Long> result = userTransactions.entrySet().stream().filter(entry -> entry.getValue() >= threshold)
				.sorted(Map.Entry.comparingByKey()).map(e -> e.getKey()).collect(Collectors.toList());
		String[] res = new String[result.size()];
		int i = 0;
		for (Long r : result) {
			res[i++] = r.toString();
			System.out.println(res[i - 1]);
		}

		return res;
	}

	public static void main(String[] args) {
		String[] logs = { "88 99 200", "88 99 300", "99 32 100", "12 12 15" };
		int threshold = 2;
		processLogFile(logs, threshold);
	}

}
