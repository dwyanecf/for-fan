package com.fanchen.clearmind.leetcode.newproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a function rand7 which generates a uniform random integer in the range 1 to 7,
 * write a function rand10 which generates a uniform random integer in the range 1 to 10.
 * <p>
 * Do NOT use system's Math.random().
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: [7]
 * Example 2:
 * <p>
 * Input: 2
 * Output: [8,4]
 * Example 3:
 * <p>
 * Input: 3
 * Output: [8,1,10]
 * <p>
 * <p>
 * Note:
 * <p>
 * rand7 is predefined.
 * Each testcase has one argument: n, the number of times that rand10 is called.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 */
public class ImplementRand10UsingRand7 {

    public static int rand10() {
        int i, j;
        while ((i = rand7()) > 6) ;  // 1,2,3,4,5,6  P(i is even) = P(i is odd) = 0.5
        while ((j = rand7()) > 5) ;  // P(j==1) = P(j==2) = P(j==3) = P(j==4) = P(j==5) = 0.2
        return (i % 2 == 0) ? j : j + 5;
    }

    public static int rand7() {
        return (int) (Math.random() * 6) + 1;
    }

    public static void main(String[] args){
        Map<Integer,Integer> map = new HashMap<>();
      for(int i =0;i<3000;i++){
          int num = rand10();
          map.put(num, map.getOrDefault(num, 0)+1);
      }
        System.out.println(map.toString());
    }
}
