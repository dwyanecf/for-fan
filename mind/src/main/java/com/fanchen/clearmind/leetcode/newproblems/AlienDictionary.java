package com.fanchen.clearmind.leetcode.newproblems;

/**
 * In an alien language, surprisingly they also use english lowercase letters,
 * but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 * <p>
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 * <p>
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.)
 * According to lexicographical rules "apple" > "app", because 'l' > '∅',
 * where '∅' is defined as the blank character which is less than any other character (More info).
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are english lowercase letters.
 */
public class AlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length < 2)
            return true;

        for (int i = 1; i < words.length; i++) {
            char[] w1 = words[i - 1].toCharArray();
            char[] w2 = words[i].toCharArray();

            int min = Math.min(w1.length, w2.length);

            for (int j = 0; j < min; j++) {
                if (order.indexOf(w2[j]) < order.indexOf(w1[j])) {
                    return false;
                } else if (order.indexOf(w2[j]) == order.indexOf(w1[j])) {
                    // last
                    if (j == min - 1 && w1.length > min)
                        return false;
                    continue;
                } else
                    break;
            }
        }
        return true;
    }
}
