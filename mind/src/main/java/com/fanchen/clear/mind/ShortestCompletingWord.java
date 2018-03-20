package com.fanchen.clear.mind;

public class ShortestCompletingWord {
	
	public String shortestCompletingWord(String licensePlate, String[] words) {
		String plate = licensePlate.toLowerCase();
		int[] table = new int[26];
		for (int i = 0; i < plate.length(); i++) {
			if (Character.isLetter(plate.charAt(i))) {
				table[plate.charAt(i) - 'a']++;
			}
		}
		int min = Integer.MAX_VALUE;
		String res = null; 

		for (int i = 0; i < words.length; i++) {
			String word = words[i].toLowerCase();
			if (matchWords(word, table) && word.length() < min) {
				min = word.length();
				res = words[i];
			}
		}
		return res;
	}

	private boolean matchWords(String word, int[] table) {
		int [] targetMap = new int[26];
		 for(int i = 0; i < word.length(); i++){
			if(Character.isLetter(word.charAt(i))) {
				targetMap[word.charAt(i)-'a']++;
			}
		}
		 for(int i = 0; i < 26; i++){
	            if(table[i]!=0 && targetMap[i]<table[i]) return false;
	        }
		return true;
	}

}
