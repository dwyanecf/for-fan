package com.fanchen.clearmind.zillow.VO;

import java.util.Arrays;
import java.util.List;

public class BlackJack {

	public static int getPoints(List<String> cards) {
		int res = 0;
		int countA = 0;
		for (String card : cards) {
			if (card.equals("A")) {
				res += 11;
				countA++;
			} else if (card.equals("J") || card.equals("Q") || card.equals("K")) {
				res += 10;
			} else {
				res += Integer.valueOf(card);
			}
		}
		if (countA == 0 && res > 21) {
			System.out.println("0");
			return 0;
		}

		while (countA > 0 && res > 21) {
			res -= 10;
			countA--;
			if (res <= 21) {
				System.out.println(res);
				return res;
			}
		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		getPoints(Arrays.asList("A", "A", "A"));
		getPoints(Arrays.asList("10", "9", "A"));
		getPoints(Arrays.asList("K", "A", "1"));
	}
}
