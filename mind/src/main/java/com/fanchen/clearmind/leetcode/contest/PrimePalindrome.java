package com.fanchen.clearmind.leetcode.contest;

public class PrimePalindrome {
    public int primePalindrome(int N) {
        while (true) {
            if(!checkPalindrome(N) || !checkPrime(N)){
                N++;
            }else{
                return N;
            }
        }
    }

    public boolean checkPrime(int n) {
        if(n==1) return false;
        // fast even test.
        if(n > 2 && (n & 1) == 0)
            return false;
        // only odd factors need to be tested up to n^0.5
        for(int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    public boolean checkPalindrome(int n) {
        int r, sum = 0;
        int temp = n;
        while (n > 0) {
            r = n % 10;  //getting remainder
            sum = (sum * 10) + r;
            n = n / 10;
        }
        if (temp == sum)
            return true;
        else
            return false;
    }

}
