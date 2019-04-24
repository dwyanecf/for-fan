package com.fanchen.clearmind.leetcode.newproblems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new LogComparator());
        return logs;
    }

    class LogComparator implements Comparator<String> {
        @Override
        public int compare(String log1, String log2) {
            String[] words1 = log1.split(" ");
            String[] words2 = log2.split(" ");

            int word1Index = log1.indexOf(' ');
            int word2Index = log2.indexOf(' ');

            boolean isLetter1 = isLetter(words1);
            boolean isLetter2 = isLetter(words2);

            if (isLetter1 == true && isLetter2 == true) {
                //Then we need to sort lexicographically, but we need to ignore the first word.
                return log1.substring(word1Index + 1).compareTo(log2.substring(word2Index + 1));
            } else if (isLetter1 != isLetter2) { //This means one is true and one is false, therefore, one is a digit the other is a letter
                return isLetter1 ? -1 : 1; //If the first word is a letter log, then second one is digit log and vice-versa.
            } else{
                //else if isLetter1 == false && isLetter2 == false, both are digits therefore maintain the ordering.
                return 0;
            }
        }

        boolean isLetter(String[] words) {
            //Get the first word of split string (not the id)
            String firstWord = words[1]; //First word after id
            //Get the first letter of the first word
            char c = firstWord.charAt(0);
            if (Character.isLetter(c)) return true;

            return false;
        }
    }
}
